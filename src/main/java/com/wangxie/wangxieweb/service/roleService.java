package com.wangxie.wangxieweb.service;

import com.wangxie.wangxieweb.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface roleService {
    List<Role> getAllRole();
    List<Map> getAllRoleNameAndId();
}
