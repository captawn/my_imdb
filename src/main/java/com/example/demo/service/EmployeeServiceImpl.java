package com.example.demo.service;

import com.example.demo.domain.EmployeeDomain;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.mapper.EmployeeMapperHelper;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapperHelper mapperHelper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapperHelper mapperHelper) {
        this.employeeRepository = employeeRepository;
        this.mapperHelper = mapperHelper;
    }

    @Override
    public List<EmployeeDomain> getAllEmployees() {
        List<EmployeeEntity> empEntities = employeeRepository.findAll();
        return mapperHelper.convertEmployeeEntityListToEmployeeDomainList(empEntities);
    }

    @Override
    public Long saveEmployee(EmployeeDomain employee) {
        EmployeeEntity employeeEntity = mapperHelper.convertEmployeeDomainToEmployeeEntity(employee);
        EmployeeEntity savedEmp =  employeeRepository.save(employeeEntity);
        return savedEmp.getId();
    }

    @Override
    public EmployeeDomain findEmployeeById(Long empId) {
        Optional<EmployeeEntity> byId = employeeRepository.findById(empId);
        if(byId.isPresent()){
            EmployeeEntity foundEmp = byId.get();
            return mapperHelper.convertEmployeeEntityToEmployeeDomain(foundEmp);
        }
        throw new EmployeeNotFoundException("There is no employee by id " + empId);
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        employeeRepository.deleteById(empId);
    }

}
