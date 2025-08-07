package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public class EmployeeServiceImpl implements  EmployeeService{
    private final EmployeeRepository employeeRepository;
   @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> getAllEmployees() {
        System.err.println("Getting All Employees!");
        return employeeRepository.findAll();
    }
}
