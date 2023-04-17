package com.ncs.employeeservice.mapper;

import com.ncs.employeeservice.dto.EmployeeDto;
import com.ncs.employeeservice.entity.Employee;

public class EmployeeAutoMapper {
    private EmployeeAutoMapper() {
        throw new IllegalStateException("Utility class");
    }


    /**
     * @param employee input
     * @return EmployeeDto as output
     */
    public static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setDepartmentCode(employee.getDepartmentCode());
        return employeeDto;
    }

    /**
     * @param employeeDto input
     * @return employee Entity as output
     */
    public static Employee mapToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setDepartmentCode(employeeDto.getDepartmentCode());
        return employee;
    }
}
