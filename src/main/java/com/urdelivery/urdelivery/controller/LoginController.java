package com.urdelivery.urdelivery.controller;

import com.urdelivery.urdelivery.base.qualifier.LoggedIn;
import com.urdelivery.urdelivery.entity.Driver;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;

@SessionScoped
@Named
public class LoginController implements Serializable {

    @Inject
    CredentialsValidator credentialsValidator;

    private Driver driver;

    public void login() {
        System.out.println(" user being logged in ...");

        driver = new Driver();
        
//        List<Driver> results = userDatabase.createQuery(
//                        "select u from User u where u.username = :username and u.password = :password")
//                .setParameter("username", credentials.getUsername())
//                .setParameter("password", credentials.getPassword())
//                .getResultList();
//
//        if (!results.isEmpty()) {
//            user = results.get(0);
//        }
//        else {
//            // perhaps add code here to report a failed login
//        }
        System.out.println("user name " + credentialsValidator.getEmail());
        System.out.println("user name " + credentialsValidator.getPassword());
        ExternalContext ec = FacesContext.getCurrentInstance()
                .getExternalContext();
        try {
            ec.redirect(ec.getRequestContextPath()
                    + "/index.xhtml");
//                    + "/faces/jsf/index.xhtml");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void logout() {
        driver = null;
    }

    public boolean isLoggedIn() {
        return driver != null;
    }

    @Produces
    @LoggedIn
    Driver getCurrentUser() {
        return driver;
    }

}

