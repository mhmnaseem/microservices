package com.ncs.departmentservice.services.impl;

import com.ncs.departmentservice.dto.DepartmentDto;
import com.ncs.departmentservice.entity.Department;
import com.ncs.departmentservice.mapper.DepartmentMapper;
import com.ncs.departmentservice.repository.DepartmentRepository;
import com.ncs.departmentservice.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department rawDepartment= DepartmentMapper.mapper.mapToDepartment(departmentDto);
        Department savedDepartment=departmentRepository.save(rawDepartment);
        return DepartmentMapper.mapper.mapToDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department=departmentRepository.findDepartmentByDepartmentCode(code);
        return DepartmentMapper.mapper.mapToDto(department);
    }
}
