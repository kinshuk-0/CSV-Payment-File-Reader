package com.example.wio.assignment.repository;

import com.example.wio.assignment.entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentInfo, Long> {

    @Query("SELECT e FROM PaymentInfo e WHERE e.verified IS NULL AND :currTime - e.createdAt >=  5*60*1000")
    List<PaymentInfo> findAllUnverified(Long currTime);
}
