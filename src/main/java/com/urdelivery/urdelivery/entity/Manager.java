package com.urdelivery.urdelivery.entity;

import com.urdelivery.urdelivery.base.Person;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Manager extends Person {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    Agency agency;

    private Timestamp created_at;

}
