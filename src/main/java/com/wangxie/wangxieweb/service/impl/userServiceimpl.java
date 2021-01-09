package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.service.userService;
import com.wangxie.wangxieweb.entity.User;
import com.wangxie.wangxieweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class userServiceimpl implements userService {//Service接口的实现层，主要进行业务逻辑处理

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String,String>> findAll() {//万能服务器信息暴露接口
        List<User> userList = userMapper.findAll();//从数据库中拉出user表的所有数据
//        List<String> userNameList = new ArrayList<>();//仅将某字段列传到前台接口
//        for (User user : userList) {
//            userNameList.add(user.getName());
//        }
        List<Map<String,String>> userNameList = new ArrayList<>();//利用List<map>仅将用户名和真实姓名传到前台接口
        for (User user : userList) {
            Map<String,String> map = new HashMap<>();
            map.put("username",user.getUsername());
            map.put("name",user.getName());
            userNameList.add(map);
//            System.out.println(map.get("username"));
        }
        return userNameList;//返回前台的是已经不是User类的List了
    }

    public List<User> getUserList() {//获取数据库中所有用户名和真实姓名的接口的另一种写法
        List<User> userList = userMapper.findAll();//图省事继续用了findAll这个mapper，大家不要学我
        List<User> userList2 = new ArrayList<>();
        for (User user : userList) {
            User tmp = new User();
            tmp.setUsername(user.getUsername());
            tmp.setName(user.getName());
            userList2.add(tmp);
        }
        return userList2;//返回前台的仍然是一个User类的List，但除了用户名和真实姓名外均为null
    }

    public boolean loginJudge(String username, String password) {//判断用户名密码正确性，返回值0表示用户名或密码错误，1表示正确可登录
        Integer numberOfThisUser = userMapper.loginJudge(username, password);//调用mapper层接口，实际是判断用户名为username值且密码为password值的记录条数
        return numberOfThisUser > 0;
    }

}