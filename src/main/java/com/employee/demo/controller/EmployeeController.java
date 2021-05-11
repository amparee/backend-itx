package com.employee.demo.controller;

import com.employee.demo.entity.Employee;
import com.employee.demo.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getEmployees(){
        log.info("I'm in getemployees contorller");
        return employeeService.getEmployees();
    }

    @PostMapping()
    public Employee addNew(@RequestBody Employee employee){
        log.info("Adding new employee-controller");
        return employeeService.addNew(employee);
    }

    @GetMapping("/salary/{salary}")
    public List<Employee> getBySalary(@PathVariable("salary") String salary){
        return employeeService.findBySalary(salary);
    }

    @GetMapping("/name/{name}")
    public List<Employee> getByname(@PathVariable("name") String name){
        return employeeService.findByName(name);
    }



}
