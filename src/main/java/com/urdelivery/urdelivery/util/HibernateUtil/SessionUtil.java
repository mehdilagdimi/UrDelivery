package com.urdelivery.urdelivery.util.HibernateUtil;

import com.urdelivery.urdelivery.base.Person;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.servlet.http.HttpSession;

@ApplicationScoped
public class SessionUtil {

    public HttpSession getSession(){
        return  (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(true);
    }

    public Person getCurrentUser() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if ( httpSession == null ){
            return null;
        }

        return (Person) httpSession.getAttribute("user");
    }
}
