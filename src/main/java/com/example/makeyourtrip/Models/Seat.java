package com.example.makeyourtrip.Models;

import com.example.makeyourtrip.Enums.SeatType;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;
    private String seatNo;
    private SeatType seatType;
    private Integer price;
    @ManyToOne
    @JoinColumn
    private Transport transport;
}
