package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Booking;
import com.example.makeyourtrip.RequestDTOs.BookingRequest;

public class BookingTransformers {
    public static Booking convertReqToEntity(BookingRequest bookingRequest){
        Booking booking=Booking.builder().journeyDate(bookingRequest.getJourneyDate()).seatNos(bookingRequest.getSeatNos())
                .transportId(bookingRequest.getTransportId()).build();
        return booking;
    }
}
