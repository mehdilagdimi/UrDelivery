package com.urdelivery.urdelivery.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String departure;
    private String destination;
    private Timestamp dateOfDeparture;
    private Timestamp dateOfArrival;

    private boolean isAvailable = true;

    private double weight;
    private double distanceInKm;
    private double price;

    private Timestamp accepted_at;
    private Timestamp created_at;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    Driver driver;
}
