package com.employee.demo.repository;

import com.employee.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    List<Employee> findBySalary(Double salary);
    List<Employee> findByName(String name);

}
