package com.wangxie.wangxieweb.service.impl;


import com.wangxie.wangxieweb.entity.Department;
import com.wangxie.wangxieweb.entity.Role;
import com.wangxie.wangxieweb.mapper.DepartmentMapper;
import com.wangxie.wangxieweb.service.departmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class departmentServiceimpl implements departmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> getAllDepartment() {
        return departmentMapper.getAllDepartment();
    }

    @Override
    public List<Map> getAllDepartmentNameAndId() {
        List<Map> map = new ArrayList<>();
        for(Department department : departmentMapper.getAllDepartment()){
            Map mapTmp = new HashMap<>();
            mapTmp.put("name", department.getName());
            mapTmp.put("value", department.getId().toString());
            map.add(mapTmp);
        }
        return map;
    }
}
