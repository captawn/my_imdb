package com.example.demo.service;

import com.example.demo.domain.EmployeeDomain;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDomain> getAllEmployees();

    Long saveEmployee(EmployeeDomain employee);

    EmployeeDomain findEmployeeById(Long empId);

    void deleteEmployeeById(Long empId);
}
