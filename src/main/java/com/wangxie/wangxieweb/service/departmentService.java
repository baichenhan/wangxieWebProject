package com.wangxie.wangxieweb.service;

import com.wangxie.wangxieweb.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface departmentService {
    List<Department> getAllDepartment();
    List<Map> getAllDepartmentNameAndId();
}
