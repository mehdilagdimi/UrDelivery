package com.urdelivery.urdelivery.entity;

import com.urdelivery.urdelivery.dao.DeliveryDao;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
public class Delivery implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String departure;
    private String destination;

    private String dateOfDepartureString;
    private Timestamp dateOfDeparture;
    private Timestamp dateOfArrival;

    private boolean isAvailable = true;

    private double weight;
    private double distanceInKm;
    private double price;

    private Timestamp accepted_at;
    private Timestamp created_at;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    Driver driver;

    public Delivery (){

    }
    public Delivery(long id, String departure, String destination, Timestamp created_at, Timestamp dateOfDeparture, Timestamp dateOfArrival, double weight, double distanceInKm, double price,boolean isAvailable, Timestamp accepted_at) {
        this.id = id;
        this.departure = departure;
        this.destination = destination;
        this.dateOfDeparture = dateOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.isAvailable = isAvailable;
        this.weight = weight;
        this.distanceInKm = distanceInKm;
        this.price = price;
        this.accepted_at = accepted_at;
        this.created_at = created_at;
    }

    @Override
    public Delivery clone() {
        return new Delivery(getId(), getDeparture(), getDestination(), getCreated_at(), getDateOfDeparture(), getDateOfArrival() ,getWeight(), getDistanceInKm(),
                getPrice(), isAvailable(), getAccepted_at());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Timestamp getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Timestamp dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
    public String getDateOfDepartureString() {
        return dateOfDepartureString;
    }

    public void setDateOfDepartureString(String dateOfDepartureString) {
        this.dateOfDepartureString = dateOfDepartureString;
        try{
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        // you can change format of date
        Date date = formatter.parse(this.dateOfDepartureString);
        Timestamp timeStampDate = new Timestamp(date.getTime());
        this.dateOfDeparture = timeStampDate;
        } catch (ParseException e){
            e.printStackTrace();
        }
    }


    public Timestamp getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Timestamp dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Timestamp getAccepted_at() {
        return accepted_at;
    }

    public void setAccepted_at(Timestamp accepted_at) {
        this.accepted_at = accepted_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Delivery delivery = (Delivery) o;
//
//        if (id != delivery.id) return false;
//        if (isAvailable != delivery.isAvailable) return false;
//        if (Double.compare(delivery.weight, weight) != 0) return false;
//        if (Double.compare(delivery.distanceInKm, distanceInKm) != 0) return false;
//        if (Double.compare(delivery.price, price) != 0) return false;
//        if (!Objects.equals(departure, delivery.departure)) return false;
//        if (!Objects.equals(destination, delivery.destination))
//            return false;
//        if (!Objects.equals(dateOfDeparture, delivery.dateOfDeparture))
//            return false;
//        if (!Objects.equals(dateOfArrival, delivery.dateOfArrival))
//            return false;
//        if (!Objects.equals(accepted_at, delivery.accepted_at))
//            return false;
//        return Objects.equals(created_at, delivery.created_at);
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (departure != null ? departure.hashCode() : 0);
//        result = 31 * result + (destination != null ? destination.hashCode() : 0);
//        result = 31 * result + (dateOfDeparture != null ? dateOfDeparture.hashCode() : 0);
//        result = 31 * result + (dateOfArrival != null ? dateOfArrival.hashCode() : 0);
//        result = 31 * result + (isAvailable ? 1 : 0);
//        temp = Double.doubleToLongBits(weight);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(distanceInKm);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(price);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (accepted_at != null ? accepted_at.hashCode() : 0);
//        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
//        return result;
//    }

}
