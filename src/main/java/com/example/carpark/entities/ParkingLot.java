package com.example.carpark.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties("carList")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parkId;

    @Column(length = 20)
    private int parkArea;

    @Column(length = 50)
    private String parkName;

    @Column(length = 11)
    private String parkPlace;

    @Column(length = 20)
    private int parkPrice;

    @Column(length = 50)
    private String parkStatus;

    //One To Many Here
    @OneToMany(mappedBy = "parkId", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JsonIgnoreProperties(value = "parkId")
    private List<Car> carList;

    public int getParkId() {
        return parkId;
    }

    public void setParkId(int parkId) {
        this.parkId = parkId;
    }

    public int getParkArea() {
        return parkArea;
    }

    public void setParkArea(int parkArea) {
        this.parkArea = parkArea;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(String parkPlace) {
        this.parkPlace = parkPlace;
    }

    public int getParkPrice() {
        return parkPrice;
    }

    public void setParkPrice(int parkPrice) {
        this.parkPrice = parkPrice;
    }

    public String getParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(String parkStatus) {
        this.parkStatus = parkStatus;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
