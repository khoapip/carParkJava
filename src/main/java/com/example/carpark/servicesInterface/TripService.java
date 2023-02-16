package com.example.carpark.servicesInterface;


import com.example.carpark.entities.Trip;

import java.util.List;

public interface TripService {

    public void add(Trip trip);

    public void deleteById(int id);

    public List<Trip> findAll();

    public List<Trip> findByDriver(String name);

    public Trip findById(int id);

    public void edit(Trip trip);

}
