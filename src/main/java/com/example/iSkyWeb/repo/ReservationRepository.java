package com.example.iSkyWeb.repo;

import com.example.iSkyWeb.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
