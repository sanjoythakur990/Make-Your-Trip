package com.example.makeyourtrip.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String routeDetails;
    private LocalDate journeyDate;
    private LocalTime startTime;
    private Integer totalCostPaid;
    private String AllSeatNos;
    @OneToOne
    @JoinColumn
    private Booking booking;
}
