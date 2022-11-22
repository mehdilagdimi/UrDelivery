package com.urdelivery.urdelivery.entity;

import com.urdelivery.urdelivery.base.Person;


//Singleton
public class Admin extends Person {

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
