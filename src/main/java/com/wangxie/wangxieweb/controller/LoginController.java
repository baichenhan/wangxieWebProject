package com.wangxie.wangxieweb.controller;

import com.wangxie.wangxieweb.service.userService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {//登录逻辑的前端控制器

    @Autowired
    private userService userService;

    @RequestMapping("")
    public ModelAndView loginIndex(){//登录页面接口
        return new ModelAndView("login");//返回一个非常丑陋的页面login.html
    }

    @RequestMapping(value = "/judge",method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView loginJudge(@NotNull HttpServletRequest request){//接收前台login.html中form数据的接口
        String username = request.getParameter("username");//html表单传来的username
        String password = request.getParameter("password");//html表单传来的password
//        System.out.println(username);
        boolean judge = userService.loginJudge(username, password);//调用服务层接口判断账号密码是否正确
        if(judge)
            return new ModelAndView("success");//若正确，跳转到一个更丑陋的页面success.html
        else
            return new ModelAndView("fail");//若失败，跳转一个同样丑陋的页面fail.html
    }
}