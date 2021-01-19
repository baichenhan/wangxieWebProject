package com.wangxie.wangxieweb.mapper;

import com.wangxie.wangxieweb.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    List<Role> getAllRole();
    int findRoleIdByName(String name);
    String findRoleById(int id);//根据role_id找到对应的角色名
}
