package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.RequestDTOs.AddTransportDto;

public class TransportTransformer {
    public static Transport convertDtoToEntity(AddTransportDto addTransportDto){
        Transport transportObj=Transport.builder().modeOfTransport(addTransportDto.getModeOfTransport())
                                                    .journeyDate(addTransportDto.getJourneyDate())
                                                    .journeyTime(addTransportDto.getJourneyTime())
                                                    .startTime(addTransportDto.getStartTime())
                                                    .build();
        return transportObj;
    }
}
