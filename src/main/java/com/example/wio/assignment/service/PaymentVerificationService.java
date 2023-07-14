package com.example.wio.assignment.service;

import com.example.wio.assignment.dto.PaymentInfoDto;

public interface PaymentVerificationService {
    boolean saveCsvData();
    
    PaymentInfoDto getPaymentVerificationData(String paymentId);
}
