package com.example.iSkyWeb.service;

import com.example.iSkyWeb.domain.Reservation;
import com.example.iSkyWeb.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepo;

    public Reservation save(Reservation reservation) {
        return reservationRepo.save(reservation);
    }
}
