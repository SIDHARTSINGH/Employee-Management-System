package com.singh.sidhart.employee.services;


import com.singh.sidhart.employee.model.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
    ResponseEntity createEmployee(Employee employee);
}
