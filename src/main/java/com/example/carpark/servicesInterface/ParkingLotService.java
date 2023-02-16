package com.example.carpark.servicesInterface;


import com.example.carpark.entities.ParkingLot;

import java.util.List;

public interface ParkingLotService {

    public void add(ParkingLot lot);

    public void deleteById(int id);

    public List<ParkingLot> findAll();

    public List<ParkingLot> findByParkArea(int area);

    public List<ParkingLot> findByParkPlace(String place);


    public ParkingLot findById(int id);

    public void edit(ParkingLot lot);

}
