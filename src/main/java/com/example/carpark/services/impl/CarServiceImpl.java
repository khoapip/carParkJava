package com.example.carpark.services.impl;

import com.example.carpark.entities.Car;
import com.example.carpark.entities.ParkingLot;
import com.example.carpark.repositories.CarRepo;
import com.example.carpark.repositories.ParkingLotRepo;
import com.example.carpark.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo repo;

    @Autowired
    ParkingLotRepo parkingLotRepo;

    @Override
    public boolean idExist(String license) {
        return repo.existsById(license);
    }

    @Override
    public void add(Car car) {
        repo.save(car);
    }

    @Override
    public void deleteByLicensePlate(String license) {
        repo.deleteById(license);
    }

    @Override
    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        repo.findAll().forEach(carList::add);
        return carList;
    }

    @Override
    public Car findByLicensePlate(String license) {
        return repo.findById(license).orElse(null);
    }

    @Override
    public List<Car> findByColor(String color) {
        return repo.findByCarColor(color);
    }

    @Override
    public List<Car> findByCarType(String type) {
        return repo.findByCarType(type);
    }

    @Override
    public List<Car> findByCompany(String company) {
        return repo.findByCompany(company);
    }

    @Override
    public List<Car> findByParkId(int parkId) {
        ParkingLot parkingLot = parkingLotRepo.findById(parkId).orElse(null);
        return repo.findByParkId(parkingLot);
    }

    @Override
    public void edit(Car car) {
        Optional<Car> optionalCar = repo.findById(car.getLicensePlate());
        if (optionalCar.isPresent()){
            Car opCar = optionalCar.get();
            opCar.setCarColor(car.getCarColor());
            opCar.setCarType(car.getCarType());
            opCar.setCompany(car.getCompany());
            opCar.setParkId(car.getParkId());
        }
    }
}
