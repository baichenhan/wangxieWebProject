package com.wangxie.wangxieweb.entity;

import java.io.Serializable;
import java.security.SecureRandom;

public class User  implements Serializable {//对应用户user的实体类
    private String username;//用户名
    private String password;//密码
    private String grade;//年级
    private String name;//真实姓名
    private String gender;//性别
    private String identity;//身份

    public String getUsername() {
        return username;
    }//user类的get方法们
    public String getPassword() {
        return password;
    }
    public String getGrade() {
        return grade;
    }
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public String getIdentity() {
        return identity;
    }


    public void setUsername(String username) {
        this.username = username;
    }//user类的set方法们
    public void setPassword(String password) { this.password = password; }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
