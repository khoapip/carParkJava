package com.example.carpark.repositories;

import com.example.carpark.entities.Car;
import com.example.carpark.entities.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepo extends CrudRepository<Car, String> {
    public List<Car> findByCarColor(String carColor);

    public List<Car> findByCarType(String carType);

    public List<Car> findByCompany(String company);

    public List<Car> findByParkId(ParkingLot parkId);


}
