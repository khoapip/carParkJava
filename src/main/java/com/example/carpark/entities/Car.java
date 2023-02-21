package com.example.carpark.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Car {

    @Id
    @Size(max=50, message = "License Plate should be within 50 characters")
    @Column(length = 50)
    @NotBlank(message = "License Plate should not be blank")
    private String licensePlate;

    @Column(length = 11)
    @NotBlank(message = "car Color should not be blank")
    @Size( max = 11, message = "car Color should be within 11 characters")
    private String carColor;

    @Column(length = 50)
    @Size(max = 50, message = "car Type should be within 50 characters")
    private String carType;

    @Column(length = 50)
    @Size(max = 50, message = "car company should be within 50 characters")
    private String company;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
