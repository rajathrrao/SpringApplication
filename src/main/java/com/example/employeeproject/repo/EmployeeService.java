package com.example.employeeproject.repo;

import java.util.UUID;

import javax.transaction.Transactional;

import com.example.employeeproject.exception.UserNotFoundException;
import com.example.employeeproject.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    private EmployeeRepo employeeRepo;
    
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo=employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserNotFoundException("User by id "+id+" was not found."));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }
}
