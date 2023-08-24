package com.example.makeyourtrip.Models;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="routes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;
    private City fromCity;
    private City toCity;
    private String listOfStopsInBetween;
    private Date tarvelDate;
    private ModeOfTransport modeOfTransport;
}
