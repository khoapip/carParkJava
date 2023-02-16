package com.example.carpark.controller;


import com.example.carpark.entities.Ticket;
import com.example.carpark.servicesInterface.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<Ticket> getByLicense(@PathVariable int id){

        Ticket ticket = service.findById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody Ticket ticket){
        service.add(ticket);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> findAll(){
        List<Ticket> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody Ticket ticket){
        service.edit(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
