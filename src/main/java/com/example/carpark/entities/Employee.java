package com.example.carpark.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.sql.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    @Column(length = 20)
    private int employeeID;

    @Column(length = 50)
    @NotBlank(message = "Employee Account should not be blank")
    @Size(max = 50, message = "Employee Account should be within 50 characters")
    private String account;

    @Column(length = 10)
    @NotBlank(message = "Department should not be blank")
    @Size(max = 10, message = "Department should be within 10 characters")
    private String department;

    @Column(length = 50)
    @Size(max = 50, message = "Employee Address should be within 50 characters")
    private String employeeAddress;

    @Column
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date employeeBirthdate;

    @Column(length = 50)
    @Size(max = 50, message = "Employee Email should be within 50 characters")
    private String employeeEmail;

    @Column(length = 50)
    @Size(max = 50, message = "Employee Name should be within 50 characters")
    @NotBlank(message = "Employee Name should not be blank")
    private String employeeName;

    @Column(length = 50)
    @Size(max = 50, message = "Employee Phone should be within 50 characters")
    @NotBlank(message = "Employee Phone should not be blank")
    private String employeePhone;

    @Column(length = 20)
    @Size(max = 20, message = "Password should be within 20 characters")
    @NotBlank(message = "Password should not be blank")
    private String password;

    @Column(length = 1)
    @Size(max = 1, message = "Sex should only contain one character")
    @NotBlank(message = "Sex should not be empty")
    private String sex;


    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeBirthdate() {
        return employeeBirthdate;
    }

    public void setEmployeeBirthdate(Date employeeBirthdate) {
        this.employeeBirthdate = employeeBirthdate;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
