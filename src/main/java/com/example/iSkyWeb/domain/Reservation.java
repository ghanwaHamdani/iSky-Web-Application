package com.example.iSkyWeb.domain;
import jakarta.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Reservation() {}
    public void setFlight(Flight flight) { this.flight = flight; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }
}
