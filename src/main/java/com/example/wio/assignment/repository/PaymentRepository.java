package com.example.wio.assignment.repository;

import com.example.wio.assignment.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentInfo, Long> {
}
