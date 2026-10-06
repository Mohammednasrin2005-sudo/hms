package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "doctor")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Doctor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "qualification", nullable = false)
    private String qualification;

    @Column(name = "consultation_fee")
    private BigDecimal consultationFee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}