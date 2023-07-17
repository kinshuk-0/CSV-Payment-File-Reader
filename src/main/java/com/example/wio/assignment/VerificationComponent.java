package com.example.wio.assignment;

import com.example.wio.assignment.dao.PaymentDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VerificationComponent {
    @Autowired
    PaymentDao paymentDao;
    @Scheduled(fixedDelay = 2*1000)
    private void paymentVerificationJob() {
        paymentDao.updatePaymentVerificationStatus();
        log.info("VERIFICATION UNDERWAY");
    }
}
