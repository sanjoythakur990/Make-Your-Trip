package com.example.makeyourtrip.RequestDTOs;

import com.example.makeyourtrip.Enums.City;
import lombok.Data;

@Data
public class AddRouteDto {
    private City fromCity;
    private City toCity;
    private String stopsInBetween;
}
