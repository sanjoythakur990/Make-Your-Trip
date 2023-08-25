package com.example.makeyourtrip.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "bookings")
@Data
// This will keep a record of already booked seats on a particular date of a particular transportId
public class Booking {
    @Id
    private Integer bookingId;
    private String seatNos;    // Comma separated values:1A,1C
    private Date journeyDate;
    private Integer transportId;
    @ManyToOne
    @JoinColumn
    private Transport transport;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private TicketEntity ticketEntity;

    @ManyToOne
    @JoinColumn
    private User user;

}
