package com.urdelivery.urdelivery.dao;

import com.urdelivery.urdelivery.base.IUser;
import com.urdelivery.urdelivery.entity.Delivery;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.io.Serializable;


@ApplicationScoped
@Named
public class DeliveryDao extends AbstractHibernateDao<Delivery> implements Serializable {
    public DeliveryDao(){
        setClazz(Delivery.class);
    }

}

