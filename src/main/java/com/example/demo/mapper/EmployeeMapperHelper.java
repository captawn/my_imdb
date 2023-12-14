package com.example.demo.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.demo.domain.EmployeeDomain;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperHelper {

    private final ObjectMapper mapper;

    @Autowired
    public EmployeeMapperHelper(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<EmployeeDomain> convertEmployeeEntityListToEmployeeDomainList(List<EmployeeEntity> employeeEntities){
        List<EmployeeDomain> employees = new ArrayList<>();
        for(EmployeeEntity emp: employeeEntities){
            employees.add(mapper.convertValue(emp, EmployeeDomain.class));
        }

        return employees;
    }

    public List<EmployeeDTO> convertEmployeeDomainListToEmployeeDTOList(List<EmployeeDomain> employees){
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        for(EmployeeDomain emp: employees){
            employeeDTOs.add(mapper.convertValue(emp, EmployeeDTO.class));
        }

        return employeeDTOs;
    }

    public EmployeeEntity convertEmployeeDomainToEmployeeEntity(EmployeeDomain employee){
        return mapper.convertValue(employee, EmployeeEntity.class);
    }

    public EmployeeDomain convertEmployeeDTOToEmployeeDomain(EmployeeDTO employee){
        return mapper.convertValue(employee, EmployeeDomain.class);
    }

    public EmployeeDomain convertEmployeeEntityToEmployeeDomain(EmployeeEntity employeeEntity){
        return mapper.convertValue(employeeEntity, EmployeeDomain.class);
    }
}
