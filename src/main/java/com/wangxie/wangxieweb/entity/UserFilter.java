package com.wangxie.wangxieweb.entity;

public class UserFilter {
    public String name;
    public String grade;
    public String departmentIdString;
    public String roleIdString;
    public String majorIdString;
    public String collegeIdString;
    public Integer departmentId;
    public Integer roleId;
    public Integer majorId;
    public Integer collegeId;

    public void format() {
        if(this.name != null) {
            if(this.name.equals(""))
                this.name = null;
        }
        if(this.grade != null) {
            if(this.grade.equals(""))
                this.grade = null;
        }
        if(this.roleIdString != null)
        {
            if(this.roleIdString.equals(""))
                this.roleId = null;
            else
                this.roleId = Integer.parseInt(this.roleIdString);
        }
        if(this.majorIdString != null)
        {
            if(this.majorIdString.equals(""))
                this.majorId = null;
            else
                this.majorId = Integer.parseInt(this.majorIdString);
        }
        if(this.collegeIdString != null)
        {
            if(this.collegeIdString.equals(""))
                this.collegeId = null;
            else
                this.collegeId = Integer.parseInt(this.collegeIdString);
        }
        if(this.departmentIdString != null)
        {
            if(this.departmentIdString.equals(""))
                this.departmentId = null;
            else
                this.departmentId = Integer.parseInt(this.departmentIdString);
        }
    }

    public void printf() {
        System.out.println("UserFliter.name is : " + this.name);
        System.out.println("UserFliter.grade is : " + this.grade);
        System.out.println("UserFliter.department is : " + this.departmentId);
        System.out.println("UserFliter.roleId is : " + this.roleId);
        System.out.println("UserFliter.majorId is : " + this.majorId);
        System.out.println("UserFliter.collegeId is : " + this.collegeId);
    }
}
