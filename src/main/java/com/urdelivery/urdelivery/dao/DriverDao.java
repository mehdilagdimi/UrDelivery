package com.urdelivery.urdelivery.dao;

import com.urdelivery.urdelivery.base.IUser;
import com.urdelivery.urdelivery.entity.Driver;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.io.Serializable;


@ApplicationScoped
@Named
public class DriverDao extends AbstractHibernateDao<Driver> implements IUser<Driver>, Serializable {
    public DriverDao(){
        setClazz(Driver.class);
    }

    @Override
    public Driver getRecordByEmail(String email) {
        Session session = getCurrentSession();
        try{
            session.beginTransaction();
            Driver driver =  session.createQuery("select a from Driver a where email = :email", Driver.class)
                    .setParameter("email", email)
                    .getSingleResult();
//            session.close();

            return driver;

        }catch (NoResultException ex){
            System.out.println(ex.getMessage());

            return null;

        }finally {
            session.getTransaction().commit();
        }
    }

    @Override
    public Integer login(Driver entity) {
        return null;
    }
}

