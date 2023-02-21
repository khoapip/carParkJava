package com.example.carpark.mapper;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entities.Employee;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapper {

    public EmployeeDTO toEmployeeDTO(Employee em){
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDepartment(em.getDepartment());
        dto.setAccount(em.getAccount());
        dto.setEmployeeAddress(em.getEmployeeAddress());
        dto.setEmployeeName(em.getEmployeeName());
        dto.setEmployeeBirthdate(em.getEmployeeBirthdate());
        dto.setEmployeeEmail(em.getEmployeeEmail());
        dto.setEmployeePhone(em.getEmployeePhone());
        dto.setPassword(em.getPassword());
        dto.setSex(em.getSex());
        dto.setPassword(null);
        return dto;
    }

    public Employee toEmployee(EmployeeDTO dto){
        Employee em = new Employee();
        em.setDepartment(dto.getDepartment());
        em.setAccount(dto.getAccount());
        em.setEmployeeAddress(dto.getEmployeeAddress());
        em.setEmployeeName(dto.getEmployeeName());
        em.setEmployeeBirthdate(dto.getEmployeeBirthdate());
        em.setEmployeeEmail(dto.getEmployeeEmail());
        em.setEmployeePhone(dto.getEmployeePhone());
        em.setPassword(dto.getPassword());
        em.setSex(dto.getSex());

        return em;
    }
}
