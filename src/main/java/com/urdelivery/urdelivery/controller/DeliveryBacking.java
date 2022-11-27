package com.urdelivery.urdelivery.controller;

import com.urdelivery.urdelivery.entity.Delivery;
import com.urdelivery.urdelivery.entity.Driver;
import com.urdelivery.urdelivery.services.DeliveryService;
import com.urdelivery.urdelivery.util.HibernateUtil.SessionUtil;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("dtBasicView")
@RequestScoped
public class DeliveryBacking implements Serializable {

    private List<Delivery> deliveries;

    @Inject
    private DeliveryService deliveryService;

    @Inject
    private SessionUtil sessionUtil;

    @PostConstruct
    public void init() {
        deliveries = deliveryService.getDeliveries();
    }



    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void confirm(String value) {

        int deliveryId = Integer.parseInt(value);
        Driver driver = (Driver) sessionUtil.getCurrentUser();
        String message = "You have accepted";
        if(!deliveryService.confirmDelivery(deliveryId, driver.getId()) ){
            message = "Something went wrong !";
        }
        addMessage("Confirmed", message);
    }

    public void delete() {
        addMessage("Confirmed", "Record deleted");
    }

    public void addMessage(String summary, String detail) {

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);

    }
}