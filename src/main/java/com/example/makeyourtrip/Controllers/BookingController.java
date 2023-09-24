package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDTOs.BookingRequest;
import com.example.makeyourtrip.RequestDTOs.GetAvailableSeatsDto;
import com.example.makeyourtrip.ResponseDtos.AvailableSeatsResponseDto;
import com.example.makeyourtrip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @GetMapping("/getAvailableSeats")
    public ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatsDto getAvailableSeatsDto){
        List<AvailableSeatsResponseDto> seatList=bookingService.getAvailableSeatsResponse(getAvailableSeatsDto);
        return new ResponseEntity(seatList, HttpStatus.OK);
    }
    @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequest bookingRequest){
        return null;
    }
}
