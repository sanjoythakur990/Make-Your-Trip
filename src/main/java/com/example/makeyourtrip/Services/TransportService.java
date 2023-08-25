package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Enums.ModeOfTransport;
import com.example.makeyourtrip.Exceptions.RouteNotFoundException;
import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.Models.Transport;
import com.example.makeyourtrip.Repositories.RouteRepository;
import com.example.makeyourtrip.Repositories.TransportRepository;
import com.example.makeyourtrip.RequestDTOs.AddTransportDto;
import com.example.makeyourtrip.RequestDTOs.SearchFlightDto;
import com.example.makeyourtrip.ResponseDtos.FlightResult;
import com.example.makeyourtrip.Transformers.TransportTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private RouteRepository routeRepository;
    public String addTransport(AddTransportDto addTransportDto) throws Exception{
        Transport transportObj= TransportTransformer.convertDtoToEntity(addTransportDto);
        Optional<Routes> optionalRoutes=routeRepository.findById(addTransportDto.getRouteId());
        if(!optionalRoutes.isPresent())
            throw new RouteNotFoundException("Route Id is incorrect.");
        Routes route=optionalRoutes.get();
        // set FK
        transportObj.setRoute(route);
        // bidirectional mapping
        route.getTransportList().add(transportObj);
        // because of cascading effect I'm only saving parent entity
        routeRepository.save(route);
        return "Transport has been added successfully.";
    }
    public List<FlightResult> searchForFlights(SearchFlightDto searchFlightDto){
        List<Routes> routes=routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDto.getFromCity(),
                                                                    searchFlightDto.getToCity(), ModeOfTransport.FLIGHT);
        List<FlightResult> flightResultList=new ArrayList<>();
        for(Routes route:routes){
            List<Transport> transports=route.getTransportList();
            // I should add a filter(Date filter)
            for(Transport transport:transports){
                if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate())){
                    FlightResult flightResult=TransportTransformer.convertEntityToDto(transport);
                    flightResult.setListOfStopsInBetween(route.getListOfStopsInBetween());
                    flightResultList.add(flightResult);
                }
            }
        }
        return flightResultList;
    }
}
