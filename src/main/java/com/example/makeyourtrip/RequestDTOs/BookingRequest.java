package com.example.makeyourtrip.RequestDTOs;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data

public class BookingRequest {
    private String seatNos;    // Comma separated values:1A,1C
    private LocalDate journeyDate;
    private Integer transportId;
    private Integer userId;
}
