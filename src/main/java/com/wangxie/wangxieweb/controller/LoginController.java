package com.wangxie.wangxieweb.controller;

import com.wangxie.wangxieweb.service.userService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {//登录逻辑的前端控制器

    @Autowired
    private userService userService;

    @RequestMapping("/loginPage")
    public ModelAndView loginIndex(){//登录页面接口
        return new ModelAndView("login");//返回一个非常丑陋的页面login.html
    }

    @RequestMapping(value = "/judge",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Map loginJudge(@NotNull HttpServletRequest request, HttpServletResponse response){//接收前台login.html中form数据的接口
        String username = request.getParameter("username");//html表单传来的username
        String password = request.getParameter("password");//html表单传来的password
        Map map = new HashMap<>();
//        System.out.println(username);
        String judgeName = userService.loginJudge(username, password);//调用服务层接口判断账号密码是否正确
        if(judgeName != null) {
            map.put("status", 1);
            map.put("message", "登录成功");
            map.put("name", judgeName);
            Cookie cookie = new Cookie("wangxie_loginName", judgeName);//设置前端cookie
            cookie.setMaxAge(30 * 60);
            cookie.setPath("/");
            response.addCookie(cookie);

            HttpSession session = request.getSession();//设置服务器端session
            session.setAttribute("user", judgeName);
        }
        else {
            map.put("status", 0);
            map.put("message", "用户名或密码错误！");
        }
        return map;
    }
}