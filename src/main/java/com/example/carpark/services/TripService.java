package com.example.carpark.services;


import com.example.carpark.entities.Trip;

import java.util.List;

public interface TripService {

    public void add(Trip trip);

    public boolean idExist(int id);


    public void deleteById(int id);

    public List<Trip> findAll();

    public List<Trip> findByDriver(String name);

    public Trip findById(int id);

    public void edit(Trip trip);

}
