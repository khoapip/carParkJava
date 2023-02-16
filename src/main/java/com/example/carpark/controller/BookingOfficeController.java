package com.example.carpark.controller;


import com.example.carpark.entities.BookingOffice;
import com.example.carpark.servicesInterface.BookingOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/office")
public class BookingOfficeController {

    @Autowired
    private BookingOfficeService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<BookingOffice> getByLicense(@PathVariable int id){

        BookingOffice lot = service.findById(id);
        return new ResponseEntity<>(lot, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody BookingOffice office){
        service.add(office);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookingOffice>> findAll(){
        List<BookingOffice> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody BookingOffice office){
        service.edit(office);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
