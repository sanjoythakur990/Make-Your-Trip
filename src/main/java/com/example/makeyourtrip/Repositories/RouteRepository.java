package com.example.makeyourtrip.Repositories;

import com.example.makeyourtrip.Models.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Routes,Integer> {
}
