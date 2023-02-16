package com.example.carpark.controller;


import com.example.carpark.entities.ParkingLot;
import com.example.carpark.servicesInterface.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lot")
public class ParkingLotController {

    @Autowired
    private ParkingLotService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<ParkingLot> getByLicense(@PathVariable int id){

        ParkingLot lot = service.findById(id);
        return new ResponseEntity<>(lot, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody ParkingLot lot){
        service.add(lot);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParkingLot>> findAll(){
        List<ParkingLot> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody ParkingLot lot){
        service.edit(lot);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
