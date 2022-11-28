package com.urdelivery.urdelivery.controller;

import com.urdelivery.urdelivery.base.Person;
import com.urdelivery.urdelivery.base.qualifier.LoggedIn;
import com.urdelivery.urdelivery.dao.DriverDao;
import com.urdelivery.urdelivery.dao.ManagerDao;
import com.urdelivery.urdelivery.entity.Driver;
import com.urdelivery.urdelivery.entity.Manager;
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

    private Person user;
//    private Manager manager;
    @Inject
    DriverDao driverDao;
     @Inject
     ManagerDao managerDao;

    public void login() {
        System.out.println(" user being logged in ...");

//        driver = new Driver();



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
//        System.out.println("user name " + credentialsValidator.getEmail());
//        System.out.println("email " + credentialsValidator.getPassword());
        if(credentialsValidator.getRole() != null){
            switch(credentialsValidator.getRole()){
                case "Driver" :
                    Driver driver = driverDao.getRecordByEmail(credentialsValidator.getEmail());
                    user = driver;
                    break;
                case "Manager":
                    Manager manager = managerDao.getRecordByEmail(credentialsValidator.getEmail());
                    user = manager;
                    break;
            }
        }


        if(user != null) {
            if (user.getPassword().equals(credentialsValidator.getPassword())) {
                ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    if("Driver".equals(credentialsValidator.getRole())){
                        ec.redirect(ec.getRequestContextPath()
                                + "/managerDashboard.xhtml");
//                                + "/driverDashboard.xhtml");

                    } else if ("Manager".equals(credentialsValidator.getRole())){
                        ec.redirect(ec.getRequestContextPath()
                                + "/managerDashboard.xhtml");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(" user logged in failed ...");
            }
        }

    }

    public void logout() {
        user = null;
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    @Produces
    @LoggedIn
    Person getCurrentUser() {
        return user;
    }

}