package com.wangxie.wangxieweb.controller;

import com.wangxie.wangxieweb.entity.User;
import com.wangxie.wangxieweb.entity.UserData;
import com.wangxie.wangxieweb.entity.UserShow;
import com.wangxie.wangxieweb.mapper.UserMapper;
import com.wangxie.wangxieweb.service.userService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private userService userService;

    @RequestMapping("/findAll")//万能数据库暴露接口，需要的信息在impl层改字段即可获取到前台接口
    public List<Map<String,String>> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/getAllUser")
    public UserShow getAllUser(){//获取数据库所以用户的用户名和真实姓名
        return userService.getAllUser();
    }

    @RequestMapping(value = "/getUserById",method = {RequestMethod.POST, RequestMethod.GET})
    public UserData getUserById(@NotNull HttpServletRequest request) {
//        System.out.println("get the interface!");
        String id = request.getParameter("id");
//        System.out.println("this is request id :" + id);
        return userService.findUserById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/addUser",method = {RequestMethod.POST, RequestMethod.GET})
    public Map addUser(@NotNull HttpServletRequest request) {
        UserData userdata = new UserData();
        userdata.username = request.getParameter("username");
        userdata.name = request.getParameter("name");
        userdata.student_id = request.getParameter("student_id");
        userdata.sex = request.getParameter("sex");
        userdata.major = request.getParameter("major");
        userdata.college = request.getParameter("college");
        userdata.role = request.getParameter("role");
        userdata.password = request.getParameter("password");
        userdata.grade = request.getParameter("grade");
        userdata.department = request.getParameter("department");

        return userService.addUser(userdata);
    }

    @RequestMapping(value = "/deleteUserById",method = {RequestMethod.POST, RequestMethod.GET})
    public Map deleteUserById(@NotNull HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println("delete id is : " + id);
        return userService.deleteUserById(id);
    }

    @RequestMapping("/getDeleteUser")
    public UserShow getDeleteUser() {
        return userService.getDeleteUser();
    }

    @RequestMapping(value = "/recoverDeleteUser",method = {RequestMethod.POST, RequestMethod.GET})
    public Map recoverDeleteUser(@NotNull HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
//        System.out.println("recover id is : " + id);
        return userService.recoverDeleteUserById(id);
    }

    @RequestMapping(value = "/editUserByUser",method = {RequestMethod.POST, RequestMethod.GET})
    public Map editUserByUser(@NotNull HttpServletRequest request) {
        UserData userdata = new UserData();
        userdata.username = request.getParameter("username");
        userdata.name = request.getParameter("name");
        userdata.student_id = request.getParameter("student_id");
        userdata.sex = request.getParameter("sex");
        userdata.major = request.getParameter("major");
        userdata.college = request.getParameter("college");
        userdata.role = request.getParameter("role");
        userdata.password = request.getParameter("password");
        userdata.grade = request.getParameter("grade");
        userdata.department = request.getParameter("department");
        userdata.status = request.getParameter("status");
        userdata.id = request.getParameter("id");

        return userService.editUserById(userdata);
    }
}