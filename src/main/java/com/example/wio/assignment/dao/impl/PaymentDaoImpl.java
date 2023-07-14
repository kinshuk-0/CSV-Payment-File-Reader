package com.example.wio.assignment.dao.impl;

import com.example.wio.assignment.dao.PaymentDao;
import com.example.wio.assignment.entity.PaymentInfo;
import com.example.wio.assignment.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@Service
@Slf4j
public class PaymentDaoImpl implements PaymentDao {
    @Autowired
    private PaymentRepository paymentRepository;

    @Value("${verification.delay.in.minutes}")
    private int minutes;

    @Override
    public void updatePaymentInfo(PaymentInfo paymentInfo) {

        try {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Instant modifiedTime = Instant.now();
                    paymentInfo.setModifiedAt(modifiedTime);
                    paymentInfo.setVerified(randomBooleanGenerator());
                    paymentRepository.save(paymentInfo);
                }
            }, minutes * 60 * 1000);
        } catch (Exception e) {
            log.error("updatePaymentInfo scheduler - Failed", e);
        }

        paymentRepository.save(paymentInfo);
    }

    @Override
    public Optional<PaymentInfo> getPaymentVerificationById(String paymentId) {
        return paymentRepository.findById(Long.valueOf(paymentId));
    }

    private boolean randomBooleanGenerator() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
