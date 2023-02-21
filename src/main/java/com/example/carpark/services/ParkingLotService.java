package com.example.carpark.services;


import com.example.carpark.entities.ParkingLot;

import java.util.List;

public interface ParkingLotService {

    public void add(ParkingLot lot);

    public boolean idExist(int id);


    public void deleteById(int id);

    public List<ParkingLot> findAll();

    public List<ParkingLot> findByParkArea(int area);

    public List<ParkingLot> findByParkPlace(String place);


    public ParkingLot findById(int id);

    public void edit(ParkingLot lot);

}
