package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;

import java.util.List;

@Entity
public class Car {

    @Id
    private String licensePlate;

    @Column(length = 11)
    private String carColor;

    @Column(length = 50)
    private String carType;

    @Column(length = 50)
    private String company;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "parkId", referencedColumnName = "parkId")
    @JsonIgnoreProperties(value = "carList")
    ParkingLot parkId;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public ParkingLot getParkId() {
        return parkId;
    }

    public void setParkId(ParkingLot parkId) {
        this.parkId = parkId;
    }
}
