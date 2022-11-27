package com.urdelivery.urdelivery.services;

import com.urdelivery.urdelivery.dao.DeliveryDao;
import com.urdelivery.urdelivery.dao.DriverDao;
import com.urdelivery.urdelivery.entity.Delivery;
import com.urdelivery.urdelivery.entity.Driver;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@RequestScoped
public class DeliveryService implements Serializable {

    @Inject
    private DeliveryDao deliveryDao;

    @Inject
    private DriverDao driverDao;
    private List<Delivery> deliveries;

    @PostConstruct
    public void init() {
        deliveries = deliveryDao.findAll();
    }

    public List<Delivery> getDeliveries() {
        return new ArrayList<>(deliveries);
    }

    public boolean confirmDelivery(long deliveryId, long driverId) {
        Delivery delivery = deliveryDao.findOne(deliveryId);
        Driver driver = driverDao.findOne(driverId);
        delivery.setDriver(driver);
        return deliveryDao.update(delivery) != null;
    }
}