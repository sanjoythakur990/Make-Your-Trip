package com.example.makeyourtrip.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tickets")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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
