package com.singh.sidhart.employee.services;

import com.singh.sidhart.employee.entity.EmployeeEntity;
import com.singh.sidhart.employee.model.Employee;
import com.singh.sidhart.employee.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        //convert the Employee object(employee) to an object of EmployeeEntity
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepo.save(employeeEntity);

        return employee;
    }
}
