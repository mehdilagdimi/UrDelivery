package com.urdelivery.urdelivery.entity;

import com.urdelivery.urdelivery.base.Person;

import java.io.Serializable;


//Singleton
public class Admin extends Person implements Serializable {

    private static Admin admin = null;

    private Admin(){
    }
    private Admin(String fullname, String email, String passw) {
        super(fullname, email, passw);
    }

    public static Admin getInstance(String fullname, String email, String passw){
        if(admin == null) admin = new Admin(fullname, email, passw);

        return admin;
    }
}
