package com.example.wio.assignment.service.impl;

import com.example.wio.assignment.doa.PaymentDao;
import com.example.wio.assignment.dto.PaymentInfoDto;
import com.example.wio.assignment.entity.PaymentInfo;
import com.example.wio.assignment.service.PaymentVerificationService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Optional;

@Service
public class PaymentVerificationServiceImpl implements PaymentVerificationService {

    @Autowired
    private PaymentDao paymentDao;

    @Value("${csv.resource.path}")
    private String csvPath;

    @Override
    public boolean saveCsvData() {

        try(CSVReader reader = new CSVReader(new FileReader(csvPath))) {
            String[] line = reader.readNext();
            while (line != null) {

                PaymentInfo paymentInfo = new PaymentInfo();
                paymentInfo.setPaymentId(Long.parseLong(line[0]));
                paymentInfo.setCustomerId(Long.parseLong(line[1]));
                paymentInfo.setPaymentType(line[2]);

                Instant now = Instant.now();
                paymentInfo.setCreatedAt(now);

                paymentDao.updatePaymentInfo(paymentInfo);

                line = reader.readNext();
            }


        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public PaymentInfoDto getPaymentVerificationData(String paymentId) {
        Optional<PaymentInfo> optionalPaymentInfo = paymentDao.getPaymentVerificationById(paymentId);

        PaymentInfo    paymentInfo    = optionalPaymentInfo.get();
        PaymentInfoDto paymentInfoDto = new PaymentInfoDto();

        populatePaymentInfoDto(paymentInfo, paymentInfoDto);

        return paymentInfoDto;
    }

    private void populatePaymentInfoDto(PaymentInfo source, PaymentInfoDto target) {
        target.setPaymentType(source.getPaymentType());
        target.setCustomerId(source.getCustomerId());
        target.setCreatedAt(source.getCreatedAt());
        target.setVerified(source.getVerified());
    }
}
