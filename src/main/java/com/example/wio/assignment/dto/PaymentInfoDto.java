package com.example.wio.assignment.dto;

import lombok.*;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentInfoDto {

    private Long customerId;

    private String paymentType;

    private Long createdAt;

    private Boolean verified;
}
