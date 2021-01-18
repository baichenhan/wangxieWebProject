package com.wangxie.wangxieweb.controller;

import com.wangxie.wangxieweb.entity.User;
import com.wangxie.wangxieweb.entity.UserShow;
import com.wangxie.wangxieweb.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {//这是一个没有对应前端的controller，目的是在开发过程中调试用，开发完成后将接口移除（否则有暴露数据库风险！）

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

}