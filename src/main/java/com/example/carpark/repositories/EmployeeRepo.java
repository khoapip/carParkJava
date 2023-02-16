package com.example.carpark.repositories;

import com.example.carpark.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    public List<Employee> findEmployeeByEmployeeName(String employeeName);
}
