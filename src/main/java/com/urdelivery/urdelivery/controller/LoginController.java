package com.urdelivery.urdelivery.controller;

import com.urdelivery.urdelivery.base.qualifier.LoggedIn;
import com.urdelivery.urdelivery.dao.DriverDao;
import com.urdelivery.urdelivery.entity.Driver;
import com.urdelivery.urdelivery.util.HibernateUtil.Security;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;

import javax.net.ssl.HandshakeCompletedEvent;
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

        DriverDao driverDao = new DriverDao();
        Driver result = driverDao.getRecordByEmail(credentialsValidator.getEmail());

        if( result != null) {
            if(Security.checkPassword( credentialsValidator.getPassword(), result.getPassword())){
                driver = result;
                HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(true);
                session.setAttribute("user", driver);
            }
            else {
                System.out.println(" user logged in failed ...");
            }
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