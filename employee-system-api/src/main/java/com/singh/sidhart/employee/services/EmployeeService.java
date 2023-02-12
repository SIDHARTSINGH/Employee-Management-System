package com.singh.sidhart.employee.services;


import com.singh.sidhart.employee.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee updateEmployee(Long id, Employee employee);

    Employee getEmployeeById(Long id);
}
