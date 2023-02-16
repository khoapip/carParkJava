package com.example.carpark.services;

import com.example.carpark.entities.Employee;
import com.example.carpark.repositories.EmployeeRepo;
import com.example.carpark.servicesInterface.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo repo;

    @Override
    public void add(Employee em) {
        repo.save(em);
    }

    @Override
    public void deleteById(int id) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        optionalEmployee.ifPresent(employee -> repo.delete(employee));
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> em = new ArrayList<Employee>();
        repo.findAll().forEach(em::add);
        return em;
    }

    @Override
    public List<Employee> findByName(String name) {
        return repo.findEmployeeByEmployeeName(name);
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public void edit(Employee em) {
        Optional<Employee> optionalEmployee = repo.findById(em.getEmployeeID());
        if (optionalEmployee.isPresent()){
            Employee e = optionalEmployee.get();
            e.setAccount(em.getAccount());
            e.setDepartment(em.getDepartment());
            e.setEmployeeAddress(em.getEmployeeAddress());
            e.setEmployeeBirthdate(em.getEmployeeBirthdate());
            e.setEmployeeEmail(em.getEmployeeEmail());
            e.setEmployeeName(em.getEmployeeName());
            e.setEmployeePhone(em.getEmployeePhone());
            e.setSex(em.getSex());
            e.setPassword(em.getPassword());
            repo.save(e);
        }
    }
}
