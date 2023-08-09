package com.numetry.barcodegeneration.service;

import com.numetry.barcodegeneration.model.Employee;
import com.numetry.barcodegeneration.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String addEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Added successfully";
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found "));
    }


}
