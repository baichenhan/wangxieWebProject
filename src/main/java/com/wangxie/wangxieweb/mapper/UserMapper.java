package com.wangxie.wangxieweb.mapper;

import com.wangxie.wangxieweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {//mapper层接口，mybitis框架的部分，接口函数与UserMapper.xml中的数据库操作对应
    List<User> findAll();//对应xml中的第一个select语句
    Integer loginJudge(@Param("username") String username, @Param("password") String password);//对应xml中的select count……语句
    User findUserById(int id);
    boolean isStudentIdExist(String studentId);
    boolean isUsernameExist(String username);
    int addUser(User user);
    int deleteUserById(int id);
    int recoverDeleteUserById(int id);
    int editUserByUser(User user);
}
