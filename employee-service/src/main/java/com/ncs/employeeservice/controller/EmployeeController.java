package com.ncs.employeeservice.controller;

import com.ncs.employeeservice.dto.ApiResponseDto;
import com.ncs.employeeservice.dto.EmployeeDto;
import com.ncs.employeeservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping("{email}")
    public ResponseEntity<ApiResponseDto> getEmployeeByEmail(@PathVariable String email){
        return new ResponseEntity<>(employeeService.findByEmail(email), HttpStatus.FOUND);
    }
}
