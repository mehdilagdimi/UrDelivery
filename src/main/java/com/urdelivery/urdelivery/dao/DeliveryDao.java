package com.urdelivery.urdelivery.dao;

import com.urdelivery.urdelivery.entity.Delivery;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;


@ApplicationScoped
public class DeliveryDao extends AbstractHibernateDao<Delivery> implements Serializable {
    public DeliveryDao(){
        setClazz(Delivery.class);
    }
}
