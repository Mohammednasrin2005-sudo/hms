package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment", uniqueConstraints = {
        @UniqueConstraint(name = "unique_doctor_schedule", columnNames = {"doctor_id", "appointment_date", "appointment_time"})
})
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointment_status")
    private Status appointmentStatus = Status.Scheduled;

    @Column(name = "consultation_room", nullable = false)
    private String consultationRoom;

    public enum Status { Scheduled, Completed, Cancelled }
}