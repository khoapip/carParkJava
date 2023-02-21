package com.example.carpark.services.impl;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;
import com.example.carpark.mapper.EmployeeMapper;
import com.example.carpark.repositories.EmployeeRepo;
import com.example.carpark.services.EmployeeService;
import com.example.carpark.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper mapper;

    @Autowired
    private EmployeeRepo repo;

    @Override
    public boolean idExist(int id) {
        return repo.existsById(id);
    }

    @Override
    public EmployeeDTO add(EmployeeDTO emDTO) {
        Employee em = mapper.toEmployee(emDTO);
        repo.save(em);
        EmployeeDTO dto = mapper.toEmployeeDTO(em);
        dto.setMsg("Add employee success");
        return dto;
    }

    @Override
    public EmployeeDTO deleteById(int id) {
        EmployeeDTO dto = new EmployeeDTO();
        if (idExist(id)){
            Optional<Employee> optionalEmployee = repo.findById(id);
            dto = mapper.toEmployeeDTO(optionalEmployee.get());
            optionalEmployee.ifPresent(employee -> repo.delete(employee));
            dto.setMsg("Delete Successful");
        }
        else{
            dto.setMsg("Fail");
        }

        return dto;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<Employee> em = new ArrayList<Employee>();
        repo.findAll().forEach(em::add);

        return em.stream().map(mapper::toEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDTO> findByName(String name) {
        List<Employee> ems =  repo.findEmployeeByEmployeeName(name);
        return ems.stream().map(mapper::toEmployeeDTO).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(int id) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        Employee em =  optionalEmployee.get();
        EmployeeDTO dto = mapper.toEmployeeDTO(em);
        dto.setMsg("Set Successful");
        return dto;

    }

    @Override
    public EmployeeDTO edit(EmployeeDTO inDTO) {
        Employee em = mapper.toEmployee(inDTO);
        Optional<Employee> optionalEmployee = repo.findById(em.getEmployeeID());
        EmployeeDTO dto = new EmployeeDTO();
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
            dto = mapper.toEmployeeDTO(em);
            dto.setMsg("Update Employee success");
            return dto;
        }
        dto.setMsg("Fail");
        return  dto;

    }
}
