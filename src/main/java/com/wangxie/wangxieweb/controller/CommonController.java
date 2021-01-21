package com.wangxie.wangxieweb.controller;

import com.wangxie.wangxieweb.entity.MajorShow;
import com.wangxie.wangxieweb.entity.Role;
import com.wangxie.wangxieweb.service.departmentService;
import com.wangxie.wangxieweb.service.majorService;
import com.wangxie.wangxieweb.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private roleService roleService;

    @Autowired
    private departmentService departmentService;

    @Autowired
    private majorService majorService;

    @RequestMapping("/getAllRole")
    public List<Role> getAllRole(){
        return roleService.getAllRole();
    }

    @RequestMapping("/getRoleList")
    public List<Map> getRoleList(){
        return roleService.getAllRoleNameAndId();
    }

    @RequestMapping("/getDepartmentList")
    public List<Map> getDepartment(){
        return departmentService.getAllDepartmentNameAndId();
    }

    @RequestMapping("/getAllCollege")
    public List<Map> getAllCollege() {
        return majorService.getCollegeList();
    }

    @RequestMapping("getCollegeAndMajorList")
    public List<MajorShow> getCollegeAndMajorList() throws InterruptedException {
//        Thread.sleep(1000);
        return majorService.getCollegeAndMajorList();
    }
}
