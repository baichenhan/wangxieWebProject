package com.wangxie.wangxieweb.service;

import com.wangxie.wangxieweb.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface userService {//Service层的接口声明，此处无解释。。。。。
    List<Map<String,String>> findAll();
    List<User> getUserList();
    boolean loginJudge(String username, String password);
}