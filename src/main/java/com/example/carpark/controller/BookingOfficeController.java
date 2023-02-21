package com.example.carpark.controller;

import com.example.carpark.entities.BookingOffice;
import com.example.carpark.services.BookingOfficeService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    public ResponseEntity<BookingOffice> get(@PathVariable int id){


        if (!service.idExist(id)){
            throw new EntityNotFoundException("BookingOfficeController.get::Booking Office not found, Invalid ID");
        }

        BookingOffice lot = service.findById(id);
        return new ResponseEntity<>(lot, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create( @Valid  @RequestBody BookingOffice office){
        if (service.idExist(office.getOfficeId())){
            throw new EntityExistsException("BookingOfficeController.create::Duplicate ID");
        }

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

        if (!service.idExist(id)){
            throw new EntityNotFoundException("BookingOfficeController.delete::Booking Office not found, Invalid ID");
        }

        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@Valid @RequestBody BookingOffice office){

        if (!service.idExist(office.getOfficeId())){
            throw new EntityNotFoundException("BookingOfficeController.update::Booking Office not found, Invalid ID");
        }

        service.edit(office);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
