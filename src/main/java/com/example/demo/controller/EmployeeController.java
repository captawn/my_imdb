package com.example.demo.controller;

import com.example.demo.domain.EmployeeDomain;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.mapper.EmployeeMapperHelper;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    private final EmployeeMapperHelper employeeMapperHelper;
    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeMapperHelper employeeMapperHelper) {
        this.employeeService = employeeService;
        this.employeeMapperHelper = employeeMapperHelper;
    }

    @GetMapping("/list")
    public String listEmployee(Model theEmployees){
        // call the service to bring the employees
        List<EmployeeDomain> allEmployees = employeeService.getAllEmployees();
        //convert employees to employeeDTOS
        List<EmployeeDTO> employeeDTOS = employeeMapperHelper.convertEmployeeDomainListToEmployeeDTOList(allEmployees);
        // Add the data (employeeList) to the model
        theEmployees.addAttribute("employees", employeeDTOS);
        //return the thymeleaf
        return "list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        theModel.addAttribute("employee", new EmployeeDTO());
        return "employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("empId") Long theId, Model theModel){
        //fetch the employee by id
        try{
            EmployeeDomain employeeById = employeeService.findEmployeeById(theId);
            theModel.addAttribute("employee", employeeById);
             return "employee-form";
        }
        catch (EmployeeNotFoundException exception){
            theModel.addAttribute("employee", null);
            theModel.addAttribute("exceptionMessage", exception.getMessage());

            return "employee-form";
        }

    }

    @PostMapping("/upsert")
    public String upsertEmployee(@Valid @ModelAttribute("employee") EmployeeDTO theEmployee, BindingResult result){
        //since we need the core object, we have to convert the dto object into a core object
        if(result.hasErrors()){
            return "employee-form";
        }
        EmployeeDomain employee = employeeMapperHelper.convertEmployeeDTOToEmployeeDomain(theEmployee);
        employeeService.saveEmployee(employee);

        //after saving the employee, we need to return to the main page and we redirect to the main page
        return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("empId") Long theId){
        employeeService.deleteEmployeeById(theId);
        return "redirect:/employee/list";
    }

    @PostMapping
    public Long saveEmp(@Valid @RequestBody EmployeeDTO theEmployee) {
        EmployeeDomain employee = employeeMapperHelper.convertEmployeeDTOToEmployeeDomain(theEmployee);
        Long aLong = employeeService.saveEmployee(employee);
        return aLong;
    }

}
