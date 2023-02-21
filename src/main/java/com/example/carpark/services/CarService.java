package com.example.carpark.services;


import com.example.carpark.entities.Car;

import java.util.List;

public interface CarService {

    public boolean idExist(String license);


    public void add(Car car);

    public void deleteByLicensePlate(String license);

    public List<Car> findAll();

    public Car findByLicensePlate(String license);

    public List<Car> findByColor(String color);

    public List<Car> findByCarType(String type);

    public List<Car> findByCompany(String type);


    public List<Car> findByParkId(int parkId);

    public void edit(Car car);

}
