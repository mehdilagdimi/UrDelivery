package com.urdelivery.urdelivery.entity;


import com.urdelivery.urdelivery.base.Person;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Driver extends Person {

    private String currentPlace;

    private boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "agency_id", referencedColumnName = "id")
    Agency agency;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<Delivery> deliveryList;

}
