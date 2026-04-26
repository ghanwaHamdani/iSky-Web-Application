package com.example.iSkyWeb.service;

import com.example.iSkyWeb.domain.Flight;
import com.example.iSkyWeb.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class FlightService {
    @Autowired private FlightRepository repo;
    public List<Flight> findFlightsByDest(String dest) {
        if (dest == null || dest.isEmpty()) return repo.findAll();
        return repo.findAll().stream().filter(f -> f.getDest().contains(dest)).toList();
    }
    public List<Flight> getAllFlights() {
        return repo.findAll();
    }
}
