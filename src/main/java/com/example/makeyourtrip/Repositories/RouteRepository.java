package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Enums.City;
import com.example.makeyourtrip.Enums.ModeOfTransport;
import com.example.makeyourtrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Routes,Integer> {

    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCity, City toCity, ModeOfTransport modeOfTransport);
}
