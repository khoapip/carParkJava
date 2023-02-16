package com.example.carpark.repositories;

import com.example.carpark.entities.ParkingLot;
import com.example.carpark.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ParkingLotRepo extends CrudRepository<ParkingLot, Integer> {
    public List<ParkingLot> findByParkArea(int parkArea);

    public List<ParkingLot> findByParkName(String parkName);

    public List<ParkingLot> findByParkPlace(String parkPlace);
}
