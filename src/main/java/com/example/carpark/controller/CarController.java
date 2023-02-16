package com.example.carpark.controller;


import com.example.carpark.entities.Car;
import com.example.carpark.servicesInterface.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping("/get/{license}")
    public ResponseEntity<Car> getByLicense(@PathVariable String license){

        Car car = service.findByLicensePlate(license);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/get/")
    public ResponseEntity<List<Car>> getByCarType(@RequestParam("type") String type){

        List<Car> carList = service.findByCarType(type);
        return new ResponseEntity<>(carList, HttpStatus.OK);
    }

//    @GetMapping("/get/")
//    public ResponseEntity<List<Car>> getByCarColor(@RequestParam("color") String color){
//
//        List<Car> carList = service.findByColor(color);
//        return new ResponseEntity<>(carList, HttpStatus.OK);
//    }
//
//    @GetMapping("/get/")
//    public ResponseEntity<List<Car>> getByCarCompany(@RequestParam("company") String company){
//
//        List<Car> carList = service.findByCompany(company);
//        return new ResponseEntity<>(carList, HttpStatus.OK);
//    }
//
//    @GetMapping("/get/")
//    public ResponseEntity<List<Car>> getByParkId(@RequestParam("parkId") int parkId){
//
//        List<Car> carList = service.findByParkId(parkId);
//        return new ResponseEntity<>(carList, HttpStatus.OK);
//    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody Car car){
        service.add(car);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> findAll(){
        List<Car> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{license}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String license){
        service.deleteByLicensePlate(license);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody Car car){
        service.edit(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
