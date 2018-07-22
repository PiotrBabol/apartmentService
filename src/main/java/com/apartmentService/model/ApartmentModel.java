package com.apartmentService.model;

import com.apartmentService.model.TypeOfProperty;
import com.sun.istack.internal.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
public class ApartmentModel {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    Date dateOfPostage;

    @NotNull
    double price;

    @NotNull
    int roomQuantity;

    @NotNull
    int metersSquare;

    @NotNull
    String voivodeship;

    @NotNull
    String city;

    @NotNull
    TypeOfProperty type;

    @NotNull
    Seller seller;

    public Long getId() {
        return id;
    }

    public Date getDateOfPostage() {
        return dateOfPostage;
    }

    public double getPrice() {
        return price;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public int getMetersSquare() {
        return metersSquare;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public String getCity() {
        return city;
    }

    public TypeOfProperty getType() {
        return type;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateOfPostage(Date dateOfPostage) {
        this.dateOfPostage = dateOfPostage;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRoomQuantity(int roomQuantity) {
        this.roomQuantity = roomQuantity;
    }

    public void setMetersSquare(int metersSquare) {
        this.metersSquare = metersSquare;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(TypeOfProperty type) {
        this.type = type;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public ApartmentModel(Date dateOfPostage, double price, int roomQuantity, int metersSquare, String voivodeship, String city, TypeOfProperty type, Seller seller) {
        this.dateOfPostage = dateOfPostage;
        this.price = price;
        this.roomQuantity = roomQuantity;
        this.metersSquare = metersSquare;
        this.voivodeship = voivodeship;
        this.city = city;
        this.type = type;
        this.seller = seller;
    }

    public ApartmentModel() {
    }

    @Override
    public String toString() {
        return "ApartmentModel{" +
                "id=" + id +
                ", dateOfPostage=" + dateOfPostage +
                ", price=" + price +
                ", roomQuantity=" + roomQuantity +
                ", metersSquare=" + metersSquare +
                ", voivodeship='" + voivodeship + '\'' +
                ", city='" + city + '\'' +
                ", type=" + type +
                ", seller=" + seller +
                '}';
    }
}
