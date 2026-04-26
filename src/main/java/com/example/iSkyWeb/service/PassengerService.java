package com.example.iSkyWeb.service;

import com.example.iSkyWeb.domain.Passenger;
import com.example.iSkyWeb.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepo;

    /**
     * Saves a new passenger to the database.
     * In the sequence diagram, this is called after the user clicks 'Confirm'.
     */
    public Passenger save(Passenger passenger) {
        return passengerRepo.save(passenger);
    }
}
