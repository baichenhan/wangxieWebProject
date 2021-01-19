package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.entity.UserData;
import com.wangxie.wangxieweb.entity.UserShow;
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

    public UserShow getAllUser() {//获取数据库中所有用户名和真实姓名的接口的另一种写法
        List<User> userList = userMapper.findAll();//图省事继续用了findAll这个mapper，大家不要学我
//        List<User> userList2 = new ArrayList<>();
//        for (User user : userList) {
//            user.setPassword(null);
//            System.out.println(user.getMajorId());
//        }
        UserShow usershow = new UserShow();
        usershow.code = 0;
        usershow.msg = "";
        usershow.count = userList.size();
        usershow.data = new ArrayList<>();
        System.out.println(usershow.count);
        for(int i=0; i<usershow.count; i++){
            User UserTmp = userList.get(i);
            UserData DataTmp = new UserData();
            DataTmp.id = UserTmp.getId().toString();
            DataTmp.name = UserTmp.getName();
            DataTmp.grade = UserTmp.getGrade();
            DataTmp.username = UserTmp.getUsername();
            DataTmp.student_id = UserTmp.getStudentId();
            DataTmp.department = UserTmp.getDepartment();
            DataTmp.ban_deadline = UserTmp.getBanDeadline().toString();
            if(UserTmp.isSex())
                DataTmp.sex = "男";
            else
                DataTmp.sex = "女";
            if(UserTmp.isStatus())
                DataTmp.status = "正常";
            else
                DataTmp.status = "禁用";
            DataTmp.college = userMapper.findCollegeByMajorId(UserTmp.getMajorId());
            DataTmp.major = userMapper.findMajorById(UserTmp.getMajorId());
            DataTmp.role = userMapper.findRoleById(UserTmp.getRoleId());
            usershow.data.add(i,DataTmp);
        }
        System.out.println(usershow.data.size());

        return usershow;//返回前台的是一个UserShow类的对象，内含一个data类的list
    }

    public boolean loginJudge(String username, String password) {//判断用户名密码正确性，返回值0表示用户名或密码错误，1表示正确可登录
        Integer numberOfThisUser = userMapper.loginJudge(username, password);//调用mapper层接口，实际是判断用户名为username值且密码为password值的记录条数
        return numberOfThisUser > 0;
    }

}