package com.ncs.departmentservice.mapper;

import com.ncs.departmentservice.dto.DepartmentDto;
import com.ncs.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper mapper= Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDto(Department department);
    Department mapToDepartment(DepartmentDto departmentDto);
}
