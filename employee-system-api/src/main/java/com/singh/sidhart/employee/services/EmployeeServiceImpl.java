package com.singh.sidhart.employee.services;

import com.singh.sidhart.employee.entity.EmployeeEntity;
import com.singh.sidhart.employee.model.Employee;
import com.singh.sidhart.employee.repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.List;

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

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepo.findAll();

        List<Employee> employees =
                employeeEntities.stream()
                        .map(emp -> new Employee(emp.getId(),
                                                emp.getFirstName(),
                                                emp.getLastName(),
                                                emp.getEmailId()))
                        .toList();

        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepo.findById(id).get();
        employeeRepo.delete(employee);

        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity
                = employeeRepo.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity
                = employeeRepo.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepo.save(employeeEntity);
        return employee;
    }

}
