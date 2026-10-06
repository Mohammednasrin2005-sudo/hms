package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admissionId;

    private String bedNumber; // <-- இந்த வரியைச் சேர்க்கவும்

    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String status;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}