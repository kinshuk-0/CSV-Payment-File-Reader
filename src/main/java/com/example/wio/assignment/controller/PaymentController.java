package com.example.wio.assignment.controller;

import com.example.wio.assignment.dto.PaymentInfoDto;
import com.example.wio.assignment.service.PaymentVerificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentVerificationService paymentVerificationService;

    @PostMapping("/processCsvData")
    public boolean saveEntry() {
        return paymentVerificationService.saveCsvData();
    }

    @GetMapping("/getVerificationStatus")
    public PaymentInfoDto getPaymentVerificationStatus(@RequestBody String paymentId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode         = objectMapper.readTree(paymentId);
        String paymentIdString    = jsonNode.get("paymentId").asText();

        return paymentVerificationService.getPaymentVerificationData(paymentIdString);
    }
}
