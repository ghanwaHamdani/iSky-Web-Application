package com.example.iSkyWeb.repo;

import com.example.iSkyWeb.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
