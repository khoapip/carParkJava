package com.example.carpark.services.impl;

import com.example.carpark.entities.Trip;
import com.example.carpark.repositories.TripRepo;
import com.example.carpark.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripRepo  repo;

    @Override
    public void add(Trip trip) {
        repo.save(trip);
    }

    @Override
    public boolean idExist(int id) {
        return repo.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        System.out.println(id);
        repo.deleteById(id);
    }

    @Override
    public List<Trip> findAll() {
        List<Trip> tripList = new ArrayList<>();
        repo.findAll().forEach(tripList::add);
        return tripList;
    }

    @Override
    public List<Trip> findByDriver(String name) {
        return null;
    }

    @Override
    public Trip findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void edit(Trip trip) {
        Optional<Trip> optionalTrip = repo.findById(trip.getTripId());
        if (optionalTrip.isPresent()){
            Trip opTrip = optionalTrip.get();
            opTrip.setBookedTicketNumber(trip.getBookedTicketNumber());
            opTrip.setCarType(trip.getCarType());
            opTrip.setDepartureDate(trip.getDepartureDate());
            opTrip.setDepartureTime(trip.getDepartureTime());
            opTrip.setDestination(trip.getDestination());
            opTrip.setDriver(trip.getDriver());
            opTrip.setMaximumOnlineTicketNumber(trip.getMaximumOnlineTicketNumber());
        }
    }
}
