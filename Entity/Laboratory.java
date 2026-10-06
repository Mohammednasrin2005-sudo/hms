package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "laboratory")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private String testName;
    private String testResult;
    private LocalDate testDate;
}