package com.numetry.barcodegeneration.controller;

import com.google.zxing.WriterException;
import com.numetry.barcodegeneration.model.Employee;
import com.numetry.barcodegeneration.service.EmployeeService;
import com.numetry.barcodegeneration.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qrcode")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployee() throws WriterException, IOException {
        List<Employee> employees = employeeService.getEmployees();
        if(employees.size()!=0){
            for(Employee employee:employees){
                QRCodeGenerator.generatesQRCode(employee);
            }
        }
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }


}
