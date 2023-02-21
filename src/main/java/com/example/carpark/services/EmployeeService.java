package com.example.carpark.services;


import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;


import java.util.Iterator;
import java.util.List;

public interface EmployeeService {

    public boolean idExist(int id);

    public EmployeeDTO add(EmployeeDTO emDTO);

    public EmployeeDTO deleteById(int id);

    public List<EmployeeDTO> findAll();

    public List<EmployeeDTO> findByName(String name);

    public EmployeeDTO findById(int id);

    public EmployeeDTO edit(EmployeeDTO em);

}
