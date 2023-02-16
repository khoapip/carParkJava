package com.example.carpark.repositories;

import com.example.carpark.entities.Trip;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TripRepo extends CrudRepository<Trip, Integer> {

}
