package com.urdelivery.urdelivery.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class Agency {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Timestamp created_at;

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Manager> managerList;

    @OneToMany(mappedBy = "agency", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Driver> driverList;


}
