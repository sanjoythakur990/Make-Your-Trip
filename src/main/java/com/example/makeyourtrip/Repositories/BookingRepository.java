package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    public List<Booking> findBookingsByJourneyDateAndTransportId(LocalDate journeyDate, Integer transportId);
}
