package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.entity.Role;
import com.wangxie.wangxieweb.mapper.RoleMapper;
import com.wangxie.wangxieweb.service.roleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
public class roleServiceimpl implements roleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> getAllRole() {
        return roleMapper.getAllRole();
    }

    @Override
    public List<Map> getAllRoleNameAndId() {
        List<Map> map = new ArrayList<>();
        for(Role role : roleMapper.getAllRole()){
            Map mapTmp = new HashMap<>();
            mapTmp.put("name", role.getName());
            mapTmp.put("value", role.getId().toString());
            map.add(mapTmp);
        }
        return map;
    }

}
