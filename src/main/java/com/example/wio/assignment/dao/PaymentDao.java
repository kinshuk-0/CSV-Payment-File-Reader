package com.example.wio.assignment.dao;

import com.example.wio.assignment.entity.PaymentInfo;

import java.util.Optional;

public interface PaymentDao {
    void updatePaymentInfo(PaymentInfo paymentInfo);
    Optional<PaymentInfo> getPaymentVerificationById(String paymentId);
}
