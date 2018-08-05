package com.apartmentService.apartment.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;

//unienty constraint z dateOfPostage
@Entity
public class ApartmentModel {

    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String name;
    Date dateOfPostage;
    @NotNull
    double price;
    @NotNull
    int roomQuantity;
    @NotNull
    int metersSquare;
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
    public String getName() {
        return name;
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
    public void setName(String voivodeship) {
        this.name = voivodeship;
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

    public ApartmentModel(Date dateOfPostage, double price, int roomQuantity, int metersSquare, String name, String city, TypeOfProperty type, Seller seller) {
        this.dateOfPostage = new Date(dateOfPostage.getTime());
        this.price = price;
        this.roomQuantity = roomQuantity;
        this.metersSquare = metersSquare;
        this.name = name;
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
                ", voivodeship='" + name + '\'' +
                ", city='" + city + '\'' +
                ", type=" + type +
                ", seller=" + seller +
                '}';
    }
}
