package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "billing")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private BigDecimal totalAmount;
    private String paymentStatus; // Paid, Pending
    private LocalDate billDate;
}