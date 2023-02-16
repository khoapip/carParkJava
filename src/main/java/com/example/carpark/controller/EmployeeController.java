package com.example.carpark.controller;


import com.example.carpark.entities.Employee;
import com.example.carpark.servicesInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id){

        Employee em = service.findById(id);
        return new ResponseEntity<>(em, HttpStatus.OK);
    }


    @GetMapping("/get/")
    public ResponseEntity<List<Employee>> getById(@RequestParam String name){

        List<Employee> emList = service.findByName(name);
        return new ResponseEntity<>(emList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> create(@RequestBody Employee em){
        service.add(em);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAll(){
        List<Employee> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> update(@RequestBody Employee em){
        service.edit(em);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
