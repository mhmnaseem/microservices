package com.ncs.employeeservice.services.impl;

import com.ncs.employeeservice.dto.ApiResponseDto;
import com.ncs.employeeservice.dto.DepartmentDto;
import com.ncs.employeeservice.dto.EmployeeDto;
import com.ncs.employeeservice.entity.Employee;
import com.ncs.employeeservice.feignclient.FeignApiClient;
import com.ncs.employeeservice.mapper.EmployeeAutoMapper;
import com.ncs.employeeservice.repository.EmployeeRepository;
import com.ncs.employeeservice.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private WebClient webClient;

    @Autowired
    private FeignApiClient feignApiClient;

    @Autowired
    private ApiResponseDto apiResponseDto;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee rawEmployee = EmployeeAutoMapper.mapToEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(rawEmployee);
        return EmployeeAutoMapper.mapToDto(savedEmployee);
    }
//before rest client
//    public EmployeeDto findByEmail(String email) {
//        Employee savedEmployee = employeeRepository.findEmployeeByEmail(email);
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity= restTemplate.getForEntity("http://localhost:8082/api/departments/"+savedEmployee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
//        return EmployeeMapper.mapper.mapToDto(savedEmployee);
//    }
//rest template Client
//    public ApiResponseDto findByEmail(String email) {
//        Employee savedEmployee = employeeRepository.findEmployeeByEmail(email);
//        ResponseEntity<DepartmentDto> departmentDtoResponseEntity = restTemplate.getForEntity("http://localhost:8082/api/departments/" + savedEmployee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = departmentDtoResponseEntity.getBody();
//        EmployeeDto employeeDto = EmployeeAutoMapper.mapToDto(savedEmployee);
//        apiResponseDto.setEmployee(employeeDto);
//        apiResponseDto.setDepartment(departmentDto);
//        return apiResponseDto;
//    }
//webclient methord
//    public ApiResponseDto findByEmail(String email) {
//        Employee savedEmployee = employeeRepository.findEmployeeByEmail(email);
//        DepartmentDto departmentDto = webClient
//                .get().uri("http://localhost:8082/api/departments/" + savedEmployee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();
//        EmployeeDto employeeDto = EmployeeAutoMapper.mapToDto(savedEmployee);
//        apiResponseDto.setEmployee(employeeDto);
//        apiResponseDto.setDepartment(departmentDto);
//        return apiResponseDto;
//    }
    //feign clinet
public ApiResponseDto findByEmail(String email) {
    Employee savedEmployee = employeeRepository.findEmployeeByEmail(email);
    var departmentDto = feignApiClient.getDepartmentByCode(savedEmployee.getDepartmentCode());
    EmployeeDto employeeDto = EmployeeAutoMapper.mapToDto(savedEmployee);
    apiResponseDto.setEmployee(employeeDto);
    apiResponseDto.setDepartment(departmentDto);
    return apiResponseDto;
}
}
