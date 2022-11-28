package com.urdelivery.urdelivery.controller;

import com.urdelivery.urdelivery.dao.DeliveryDao;
import com.urdelivery.urdelivery.entity.Delivery;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class CrudView implements Serializable {

    private List<Delivery> deliveries;

    private Delivery selectedDelivery;

    private List<Delivery> selectedDeliveries;

    @Inject
    private DeliveryDao deliveryDao;

    @PostConstruct
    public void init() {
        this.deliveries = new ArrayList<>();
//        this.products = this.productService.getClonedProducts(100);
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public Delivery getSelectedDelivery() {
        return selectedDelivery;
    }

    public void setSelectedDelivery(Delivery selectedDelivery) {
        this.selectedDelivery = selectedDelivery;
    }

    public List<Delivery> getSelectedDeliveries() {
        return selectedDeliveries;
    }

    public void setSelectedDeliveries(List<Delivery> selectedDeliveries) {
        this.selectedDeliveries = selectedDeliveries;
    }

    public void openNew() {
        this.selectedDelivery = new Delivery();
    }

    public void saveDelivery() {
        if (this.selectedDelivery.getId() == 0) {
            this.deliveries.add(this.selectedDelivery);
            System.out.println(" // printing list of deliveries /// ");
            this.deliveries.forEach(System.out::println);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery Added"));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery Updated"));
        }

        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public void deleteDelivery() {
//        this.products.remove(this.selectedDelivery);
//        this.selectedProducts.remove(this.selectedDelivery);
//        this.selectedDelivery = null;
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Delivery Removed"));
//        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedDeliveries()) {
            int size = this.selectedDeliveries.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }
    public boolean hasSelectedDeliveries() {
        return this.selectedDeliveries != null && !this.selectedDeliveries.isEmpty();
    }
//
    public void deleteSelectedDeliveries() {
        this.deliveries.removeAll(this.selectedDeliveries);
        this.selectedDeliveries = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
    }

}