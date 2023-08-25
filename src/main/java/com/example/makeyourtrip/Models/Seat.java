package com.example.makeyourtrip.Models;

import com.example.makeyourtrip.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "seats")
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Integer price;
    @ManyToOne
    @JoinColumn
    private Transport transport;
}
