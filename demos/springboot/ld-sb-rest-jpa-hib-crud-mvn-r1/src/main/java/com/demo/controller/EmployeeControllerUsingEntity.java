package com.demo.controller;

import com.demo.entity.EmployeeEntity;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class EmployeeControllerUsingEntity {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeControllerUsingEntity(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    List<EmployeeEntity> getAllEmployees() {
        return  employeeService.getAllEmployees();
    }
}
