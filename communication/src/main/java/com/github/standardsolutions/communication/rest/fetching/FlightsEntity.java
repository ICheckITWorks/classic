package com.github.standardsolutions.communication.rest.fetching;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "flights")
public class FlightsEntity {

    @Id
    @Column(name = "flight_id")
    private long id;

    @Column(name = "flight_no")
    private String flightNo;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "actual_departure")
    private LocalDateTime actualDeparture;

    @Column(name = "id_test")
    private UUID idTest;
}
