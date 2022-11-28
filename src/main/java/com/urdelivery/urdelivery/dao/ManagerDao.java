package com.urdelivery.urdelivery.dao;

import com.urdelivery.urdelivery.base.IUser;
import com.urdelivery.urdelivery.entity.Driver;
import com.urdelivery.urdelivery.entity.Manager;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;

import java.io.Serializable;


@ApplicationScoped
@Named
public class ManagerDao extends AbstractHibernateDao<Manager> implements IUser<Manager>, Serializable {
    public ManagerDao(){
        setClazz(Manager.class);
    }

    @Override
    public Manager getRecordByEmail(String email) {
        Session session = getCurrentSession();
        try{
            session.beginTransaction();
            Manager manager =  session.createQuery("select a from Manager a where email = :email", Manager.class)
                    .setParameter("email", email)
                    .getSingleResult();
//            session.close();

            return manager;

        }catch (NoResultException ex){
            System.out.println(ex.getMessage());

            return null;

        }finally {
            session.getTransaction().commit();
        }
    }

    @Override
    public Integer login(Manager entity) {
        return null;
    }
}

