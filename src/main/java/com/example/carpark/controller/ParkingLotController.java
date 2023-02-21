package com.example.carpark.controller;


import com.example.carpark.entities.ParkingLot;
import com.example.carpark.services.ParkingLotService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    public ResponseEntity<ParkingLot> get(@PathVariable int id){

        if (!service.idExist(id)){
            throw new EntityNotFoundException("ParkingLotController.get::Invalid ID. Parking Lot not found");
        }

        ParkingLot lot = service.findById(id);
        return new ResponseEntity<>(lot, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody ParkingLot lot){
        if (service.idExist(lot.getParkId())){
            throw new EntityExistsException("ParkingLotController.add::Duplicate ID");
        }

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
        if (!service.idExist(id)){
            throw new EntityNotFoundException("ParkingLotController.delete::Invalid ID. Parking Lot not found");
        }

        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody ParkingLot lot){
        if (!service.idExist(lot.getParkId())){
            throw new EntityNotFoundException("ParkingLotController.update::Invalid ID. Parking Lot not found");
        }

        service.edit(lot);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
