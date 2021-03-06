package com.wangxie.wangxieweb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User  implements Serializable {//实体类，对应数据库的user表的一条记录，与数据库字段一一对应。
    private String username;//用户名
    private String password;//密码
    private String grade;//年级
    private String name;//真实姓名
    private boolean sex;//性别
    private Integer id;
    private Integer roleId;
    private Integer majorId;
    private String studentId;
    private String department;
    private boolean status;
    private Timestamp banDeadline;
    private Timestamp deleteTime;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Timestamp getBanDeadline() {
        return banDeadline;
    }

    public void setBanDeadline(Timestamp banDeadline) {
        this.banDeadline = banDeadline;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }
}
