package com.wangxie.wangxieweb.mapper;


import com.wangxie.wangxieweb.entity.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> getAllDepartment();
    String getDepartmentNameById(int id);
    int getDepartmentIdByName(String name);
}
