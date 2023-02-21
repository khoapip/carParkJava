package com.example.carpark.controller;


import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;
import com.example.carpark.services.EmployeeService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
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
    public ResponseEntity<EmployeeDTO> get(@PathVariable int id){

        if (!service.idExist(id)){
            throw new EntityNotFoundException("EmployeeController.get::Invalid ID. Employee not found");
        }

        EmployeeDTO emDTO = service.findById(id);
        return new ResponseEntity<>(emDTO, HttpStatus.OK);
    }


//    @GetMapping("/get/")
//    public ResponseEntity<List<Employee>> getByName(@RequestParam String name){
//
//        List<Employee> emList = service.findByName(name);
//        return new ResponseEntity<>(emList, HttpStatus.OK);
//    }

        @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO emDTO){
        EmployeeDTO returnedDTO  = service.add(emDTO);
        return  new ResponseEntity<>(returnedDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> findAll(){
        List<EmployeeDTO> all = service.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDTO> delete(@PathVariable int id){

        EmployeeDTO emDTO = service.deleteById(id);
        return new ResponseEntity<>(emDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<EmployeeDTO> update(@Valid @RequestBody EmployeeDTO emDTO){


        EmployeeDTO returnDTO = service.edit(emDTO);
        return new ResponseEntity<>(returnDTO, HttpStatus.OK);
    }
}
