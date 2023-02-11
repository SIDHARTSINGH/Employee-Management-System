package com.singh.sidhart.employee.services;


import com.singh.sidhart.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
