package com.urdelivery.urdelivery.dao;

import com.urdelivery.urdelivery.base.IUser;
import com.urdelivery.urdelivery.entity.Driver;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

public class DriverDao extends AbstractHibernateDao<Driver> implements IUser<Driver> {
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
<<<<<<< HEAD
            session.getTransaction().commit();

=======
//            session.close();
>>>>>>> b47a0fceb880b83f8244cb5fc0b83ac36767b89d
            return driver;

        }catch (NoResultException ex){
            System.out.println(ex.getMessage());

            return null;
<<<<<<< HEAD
        } finally {
            session.close();
=======
        }finally {
            session.getTransaction().commit();
>>>>>>> b47a0fceb880b83f8244cb5fc0b83ac36767b89d
        }
    }

    @Override
    public Integer login(Driver entity) {
        return null;
    }
}

