package com.wangxie.wangxieweb.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Recruit implements Serializable {//招新recruit对应的实体类
    private Integer id;//招新编号
    private String name;//姓名
    private boolean sex;//性别
    private String studentId;//学号
    private String collageId;//学院
    private String majorId;//专业
    private String department1;//主要意向部门
    private String department2;//次要意向部门
    private boolean adjust;//调剂意向 1服从调剂；0拒绝调剂
    private String answer1;
    private String answer2;
    private String answer3;
    private Timestamp updateTime;
    private Timestamp deleteTime;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCollageId() {
        return collageId;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getDepartment1() {
        return department1;
    }

    public String getDepartment2() {
        return department2;
    }

    public boolean isAdjust() {
        return adjust;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setCollageId(String collageId) {
        this.collageId = collageId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public void setDepartment1(String department1) {
        this.department1 = department1;
    }

    public void setDepartment2(String department2) {
        this.department2 = department2;
    }

    public void setAdjust(boolean adjust) {
        this.adjust = adjust;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
}
