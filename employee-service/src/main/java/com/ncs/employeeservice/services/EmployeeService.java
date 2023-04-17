package com.ncs.employeeservice.services;

import com.ncs.employeeservice.dto.ApiResponseDto;
import com.ncs.employeeservice.dto.EmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    //before rest clinet
//    EmployeeDto findByEmail(String email);
    ApiResponseDto findByEmail(String email);
}
