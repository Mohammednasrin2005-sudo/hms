package com.smartcare.hms.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomNumber;
    private String roomType; // General, VIP, ICU
    private Boolean isOccupied = false;
}