package com.employee.demo.service;


import com.employee.demo.entity.Employee;
import com.employee.demo.repository.EmployeeJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeJpaRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addNew(Employee employee) {
        if (isValidEmployee(employee)) {
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Invalid employee");
        }
    }

    public List<Employee> findBySalary(String salary) {
        //siempre validando que salary es un double ok
        return employeeRepository.findBySalary(Double.valueOf(salary));
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    private boolean isValidEmployee(Employee e) {
        boolean isValid = false;

        if (!(e.getSalary() < 0)) {
            isValid = true;
        }

        if (e.getName().length() > 1) {
            isValid = true;
        }

        List<Employee> employees = this.getEmployees();

        if (!employees.contains(e)) {
            isValid = true;
        }
        return isValid;
    }


}
