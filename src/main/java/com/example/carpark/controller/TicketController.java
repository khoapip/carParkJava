package com.example.carpark.controller;


import com.example.carpark.entities.Ticket;
import com.example.carpark.services.TicketService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<Ticket> get(@PathVariable int id){
        if (!service.idExist(id)){
            throw new EntityNotFoundException("TicketController.get::Invalid ID. Ticket not found");
        }


        Ticket ticket = service.findById(id);
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody Ticket ticket){
        if (service.idExist(ticket.getTicketId())){
            throw new EntityExistsException("TicketController.create::Duplicate Id");
        }
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
        if (!service.idExist(id)){
            throw new EntityNotFoundException("TicketController.delete::Invalid ID. Ticket not found");
        }

        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody Ticket ticket){
        if (!service.idExist(ticket.getTicketId())){
            throw new EntityNotFoundException("TicketController.update::Invalid ID. Ticket not found");
        }

        service.edit(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
