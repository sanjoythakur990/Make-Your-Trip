package com.example.makeyourtrip.Transformers;

import com.example.makeyourtrip.Models.Routes;
import com.example.makeyourtrip.RequestDTOs.AddRouteDto;

public class RouteTransformer {
    public static Routes convertDtoToEntity(AddRouteDto addRouteDto){
        Routes routeObj=Routes.builder().fromCity(addRouteDto.getFromCity())
                                    .toCity(addRouteDto.getToCity())
                                    .listOfStopsInBetween(addRouteDto.getStopsInBetween()).build();
        return routeObj;
    }
}
