package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.*;
import com.example.makeyourtrip.Repositories.BookingRepository;
import com.example.makeyourtrip.Repositories.TransportRepository;
import com.example.makeyourtrip.Repositories.UserRepository;
import com.example.makeyourtrip.RequestDTOs.BookingRequest;
import com.example.makeyourtrip.RequestDTOs.GetAvailableSeatsDto;
import com.example.makeyourtrip.ResponseDtos.AvailableSeatsResponseDto;
import com.example.makeyourtrip.Transformers.BookingTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private UserRepository userRepository;
    public List<AvailableSeatsResponseDto> getAvailableSeatsResponse(GetAvailableSeatsDto entryDto){
        List<Booking> doneBookings=bookingRepository.findBookingsByJourneyDateAndTransportId(entryDto.getJourneyDate(),
                                                                                        entryDto.getTransportId());
        Set<String> bookedSeats=new TreeSet<>();
        for(Booking booking:doneBookings){
            String str=booking.getSeatNos();
            String bookedSeatsInThatBooking[]=str.split(",");
            for(String seatNo:bookedSeatsInThatBooking)
                bookedSeats.add(seatNo);
        }
        Transport transport=transportRepository.findById(entryDto.getTransportId()).get();
        List<Seat> seatList=transport.getSeatList();
        List<AvailableSeatsResponseDto> finalAvailableSeats=new ArrayList<>();
        for(Seat seat:seatList){
            if(!bookedSeats.contains(seat.getSeatNo())){
                AvailableSeatsResponseDto availableSeatsResponseDto= AvailableSeatsResponseDto.builder().
                        seatNo(seat.getSeatNo()).seatType(seat.getSeatType()).seatPrice(seat.getPrice()).build();
                finalAvailableSeats.add(availableSeatsResponseDto);
            }
        }
        return finalAvailableSeats;
    }
    public String makeABooking(BookingRequest bookingRequest){
        User user=userRepository.findById(bookingRequest.getUserId()).get();
        Transport transport=transportRepository.findById(bookingRequest.getTransportId()).get();
        // create the ticket entity
        TicketEntity ticketEntity=createTicketEntity(transport,bookingRequest);
        Booking booking= BookingTransformers.convertReqToEntity(bookingRequest);
        // set FK
        booking.setTransport(transport);
        booking.setUser(user);
        booking.setTicketEntity(ticketEntity);
        // bidirectional mapping
        // setting in ticket
        ticketEntity.setBooking(booking);
        user.getBookingList().add(booking);
        transport.getBookings().add(booking);
        // save karo
        bookingRepository.save( booking);
        return "Booking made successfully";
    }
    private TicketEntity createTicketEntity(Transport transport, BookingRequest bookingRequest){
        Integer totalPricePaid=findTotalPricePaid(transport,bookingRequest.getSeatNos());
        String routeDetails=findRouteDetails(transport);
        TicketEntity ticketEntity=TicketEntity. builder().AllSeatNos(bookingRequest.getSeatNos())
                .journeyDate(bookingRequest.getJourneyDate()).startTime(transport.getStartTime()).routeDetails(routeDetails)
                .totalCostPaid(totalPricePaid).build();
        return ticketEntity;
    }
    private Integer findTotalPricePaid(Transport transport, String seatNos){
        return 0;
    }
    private String findRouteDetails(Transport transport){
        Routes route=transport.getRoute();
        String result=route.getFromCity()+" TO "+route.getToCity();
        return result;
    }
}
