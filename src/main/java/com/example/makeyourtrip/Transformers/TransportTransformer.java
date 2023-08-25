package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.RequestDTOs.AddTransportDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;

public class TransportTransformer {
    public static Transport convertDtoToEntity(AddTransportDto addTransportDto){
        Transport transportObj=Transport.builder().modeOfTransport(addTransportDto.getModeOfTransport())
                                                    .journeyDate(addTransportDto.getJourneyDate())
                                                    .journeyTime(addTransportDto.getJourneyTime())
                                                    .startTime(addTransportDto.getStartTime())
                                                    .companyName(addTransportDto.getCompanyName())
                                                    .build();
        return transportObj;
    }
    public static FlightResult convertEntityToDto(Transport transport){
        FlightResult flightResult= FlightResult.builder().journeyDate(transport.getJourneyDate()).startTime(transport.getStartTime())
                            .journeyTime(transport.getJourneyTime()).companyName(transport.getCompanyName())
                            .build();
        return flightResult;
    }
}
