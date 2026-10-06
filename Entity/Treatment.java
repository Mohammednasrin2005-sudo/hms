package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long treatmentId;

    private String treatmentName;
    private String description;
    private String diagnosis;
    private String prescriptionDetails; // <-- இந்த வரியைக் கண்டிப்புடன் சேர்க்கவும்
    private Double cost;
    private LocalDate treatmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}