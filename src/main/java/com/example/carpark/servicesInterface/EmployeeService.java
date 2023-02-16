package com.example.carpark.servicesInterface;


import com.example.carpark.entities.Employee;


import java.util.Iterator;
import java.util.List;

public interface EmployeeService {

    public void add(Employee em);

    public void deleteById(int id);

    public List<Employee> findAll();

    public List<Employee> findByName(String name);

    public Employee findById(int id);

    public void edit(Employee em);

}
