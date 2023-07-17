package com.example.wio.assignment.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "payment_verification")
public class PaymentInfo {

    @Id
    @Column
    private Long paymentId;

    @Column
    private Long customerId;

    @Column
    private String paymentType;

    @Column
    private Long createdAt;

    @Column
    private Long modifiedAt;

    @Column
    private Boolean verified;
}
