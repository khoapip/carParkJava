package com.example.carpark.controller;


import com.example.carpark.entities.Trip;
import com.example.carpark.servicesInterface.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<Trip> getByLicense(@PathVariable int id){

        Trip trip = service.findById(id);
        return new ResponseEntity<>(trip, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody Trip trip){
        service.add(trip);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Trip>> findAll(){
        List<Trip> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody Trip trip){
        service.edit(trip);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
