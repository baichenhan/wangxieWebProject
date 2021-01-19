package com.wangxie.wangxieweb.service;

import com.wangxie.wangxieweb.entity.User;
import com.wangxie.wangxieweb.entity.UserData;
import com.wangxie.wangxieweb.entity.UserShow;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface userService {//Service层的接口声明，此处无解释。。。。。
    List<Map<String,String>> findAll();
    UserShow getAllUser();
    boolean loginJudge(String username, String password);
    UserData findUserById(int id);
    Map addUser(UserData userdata);
}