package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.entity.*;
import com.wangxie.wangxieweb.mapper.DepartmentMapper;
import com.wangxie.wangxieweb.mapper.MajorMapper;
import com.wangxie.wangxieweb.mapper.RoleMapper;
import com.wangxie.wangxieweb.service.userService;
import com.wangxie.wangxieweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.util.DateUtil.now;

@Service("userService")
public class userServiceimpl implements userService {//Service接口的实现层，主要进行业务逻辑处理

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MajorMapper majorMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

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

    @Override
    public UserShow getAllUser(UserFilter userFilter) {//获取数据库中所有用户名和真实姓名的接口的另一种写法
        List<User> userList = userMapper.findAll();//图省事继续用了findAll这个mapper，大家不要学我
        UserShow usershow = new UserShow();
        usershow.code = 0;
        usershow.msg = "";
        usershow.count = userList.size();
        usershow.data = new ArrayList<>();
//        System.out.println(usershow.count);
        for(int i=0; i<usershow.count; i++){
            User UserTmp = userList.get(i);
            if(UserTmp.getDeleteTime() == null || (UserTmp.getDeleteTime() != null&&UserTmp.getDeleteTime().after(now()))){
                if(userFilter.name != null && !userFilter.name.equals(UserTmp.getName()))
                    continue;
                if(userFilter.grade != null && !userFilter.grade.equals(UserTmp.getGrade()))
                    continue;
                if(userFilter.roleId != null && !userFilter.roleId.equals(UserTmp.getRoleId()))
                    continue;
                if(userFilter.majorId != null && !userFilter.majorId.equals(UserTmp.getMajorId()))
                    continue;
                if(userFilter.collegeId != null && userFilter.collegeId != majorMapper.findCollegeIdByMajorId(UserTmp.getMajorId()))
                    continue;
                if(userFilter.departmentId != null && userFilter.departmentId != departmentMapper.getDepartmentIdByName(UserTmp.getDepartment()))
                    continue;
                UserData DataTmp = new UserData();
                DataTmp.id = UserTmp.getId().toString();
                DataTmp.name = UserTmp.getName();
                DataTmp.grade = UserTmp.getGrade();
                DataTmp.username = UserTmp.getUsername();
                DataTmp.student_id = UserTmp.getStudentId();
                DataTmp.department = UserTmp.getDepartment();
                DataTmp.ban_deadline = UserTmp.getBanDeadline().toString();
                DataTmp.majorId = UserTmp.getMajorId();
                DataTmp.collegeId = majorMapper.findCollegeIdByMajorId(DataTmp.majorId);
                if(UserTmp.isSex())
                    DataTmp.sex = "男";
                else
                    DataTmp.sex = "女";
                if(UserTmp.isStatus())
                    DataTmp.status = "正常";
                else
                    DataTmp.status = "禁用";
                DataTmp.college = majorMapper.findCollegeByMajorId(UserTmp.getMajorId());
                DataTmp.major = majorMapper.findMajorById(UserTmp.getMajorId());
                DataTmp.role = roleMapper.findRoleById(UserTmp.getRoleId());
                usershow.data.add(DataTmp);
            }
        }
//        System.out.println(usershow.data.size());
        usershow.count = usershow.data.size();
        return usershow;//返回前台的是一个UserShow类的对象，内含一个data类的list
    }

    @Override
    public String loginJudge(String username, String password) {//判断用户名密码正确性，返回值0表示用户名或密码错误，1表示正确可登录
        String loginName = userMapper.loginJudge(username, password);//调用mapper层接口，实际是判断用户名为username值且密码为password值的记录条数
        return loginName;
    }

    @Override
    public UserData findUserById(int id){
        User UserTmp = new User();
        UserTmp = userMapper.findUserById(id);
        UserData DataTmp = new UserData();
        DataTmp.id = UserTmp.getId().toString();
        DataTmp.name = UserTmp.getName();
        DataTmp.grade = UserTmp.getGrade();
        DataTmp.username = UserTmp.getUsername();
        DataTmp.student_id = UserTmp.getStudentId();
        DataTmp.department = UserTmp.getDepartment();
        DataTmp.ban_deadline = UserTmp.getBanDeadline().toString();
        DataTmp.majorId = UserTmp.getMajorId();
        DataTmp.collegeId = majorMapper.findCollegeIdByMajorId(DataTmp.majorId);
        DataTmp.departmentId = departmentMapper.getDepartmentIdByName(UserTmp.getDepartment());
        DataTmp.roleId = UserTmp.getRoleId();
        System.out.println("DataTmp.departmentId is : " + DataTmp.departmentId);
        System.out.println("UserTmp.getDepartment() is : " + UserTmp.getDepartment());
        if(UserTmp.isSex())
            DataTmp.sex = "男";
        else
            DataTmp.sex = "女";
        if(UserTmp.isStatus())
            DataTmp.status = "启用";
        else
            DataTmp.status = "禁用";
        DataTmp.college = majorMapper.findCollegeByMajorId(UserTmp.getMajorId());
        DataTmp.major = majorMapper.findMajorById(UserTmp.getMajorId());
        DataTmp.role = roleMapper.findRoleById(UserTmp.getRoleId());
        return DataTmp;
    }

    @Override
    public Map addUser(UserData userdata) {
        Map map = new HashMap<>();
        User user = new User();
        user.setUsername(userdata.username);
        user.setName(userdata.name);
        user.setStudentId(userdata.student_id);
        user.setPassword(userdata.password);
        user.setGrade(userdata.grade);
        user.setBanDeadline((Timestamp) now());
        user.setRoleId(Integer.parseInt(userdata.role));
        user.setMajorId(Integer.parseInt(userdata.major));
        user.setSex(Integer.parseInt(userdata.sex) == 1);
        user.setStatus(true);
        user.setDepartment(departmentMapper.getDepartmentNameById(Integer.parseInt(userdata.department)));
//        if(userdata.sex == "男")
//            user.setSex(true);
//        else
//            user.setSex(false);
//        user.setMajorId(userMapper.findMajorIdByName(userdata.major));
//        user.setRoleId(userMapper.findRoleIdByName(userdata.role));
        if(userMapper.isStudentIdExist(user.getStudentId()))
        {
            map.put("status", 0);
            map.put("message", "学号已存在");
            return map;
        }
        if(userMapper.isUsernameExist(user.getUsername())){
            map.put("status", 0);
            map.put("message", "用户名已存在");
            return map;
        }
        int result = userMapper.addUser(user);
//        System.out.println("addUser return number is : " + result);
        map.put("status", result);
        map.put("message", "添加成功");
        return map;
    }

    @Override
    public Map deleteUserById(int id) {
        Map map = new HashMap<>();
        if(userMapper.deleteUserById(id) > 0){
            map.put("status", 1);
            map.put("message", "删除成功~");
        }
        else {
            map.put("status", 0);
            map.put("message", "删除失败！");
        }
//        System.out.println("delete here!");
        return map;
    }

    @Override
    public UserShow getDeleteUser() {
        List<User> userList = userMapper.findAll();
        UserShow usershow = new UserShow();
        usershow.code = 0;
        usershow.msg = "";
        usershow.count = userList.size();
        usershow.data = new ArrayList<>();
        for(int i=0; i<usershow.count; i++){
            User UserTmp = userList.get(i);
            if(UserTmp.getDeleteTime() != null && UserTmp.getDeleteTime().before(now())){
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
                DataTmp.college = majorMapper.findCollegeByMajorId(UserTmp.getMajorId());
                DataTmp.major = majorMapper.findMajorById(UserTmp.getMajorId());
                DataTmp.role = roleMapper.findRoleById(UserTmp.getRoleId());
                usershow.data.add(DataTmp);
            }
        }
        usershow.count = usershow.data.size();
        return usershow;
    }

    @Override
    public Map recoverDeleteUserById(int id) {
        Map map = new HashMap<>();
        if(userMapper.recoverDeleteUserById(id) > 0){
            map.put("status", 1);
            map.put("message", "恢复成功~");
        }
        else {
            map.put("status", 0);
            map.put("message", "恢复失败！");
        }
//        System.out.println("recover here!");
        return map;
    }

    @Override
    public Map editUserById(UserData userdata) throws ParseException {
        Map map = new HashMap<>();
        User user = new User();
        user.setUsername(userdata.username);
        user.setName(userdata.name);
        user.setStudentId(userdata.student_id);
//        user.setPassword(userdata.password);
        user.setGrade(userdata.grade);
        user.setBanDeadline(Timestamp.valueOf(userdata.ban_deadline));
        user.setRoleId(Integer.parseInt(userdata.role));
        user.setMajorId(Integer.parseInt(userdata.major));
        user.setSex(Integer.parseInt(userdata.sex) == 1);
        user.setStatus(Integer.parseInt(userdata.status) == 1);
        user.setDepartment(departmentMapper.getDepartmentNameById(Integer.parseInt(userdata.department)));
        user.setId(Integer.parseInt(userdata.id));
//        if(userMapper.isStudentIdExist(user.getStudentId()))
//        {
//            map.put("status", 0);
//            map.put("message", "学号已存在，修改失败");
//            return map;
//        }
//        if(userMapper.isUsernameExist(user.getUsername())){
//            map.put("status", 0);
//            map.put("message", "用户名已存在，修改失败");
//            return map;
//        }
        if(userMapper.editUserByUser(user) > 0){
            map.put("status", 1);
            map.put("message", "修改成功~");
        }
        else {
            map.put("status", 0);
            map.put("message", "修改失败~");
        }
        return map;
    }

    @Override
    public List<Map> getAllUserByDepartment() {
        List<Department> departments = new ArrayList<Department>();
        departments = departmentMapper.getAllDepartment();
        List<Map> mapList = new ArrayList<>();
        for(Department department : departments) {
            Map mapListTmp = new HashMap<>();
            List<Map> user = new ArrayList<>();
            mapListTmp.put("department", department.getName());
            for(User userTmp : userMapper.findUserByDepartment(department.getName())) {
                Map mapListUserListTmp = new HashMap<>();
                mapListUserListTmp.put("user_id", userTmp.getId().toString());
                mapListUserListTmp.put("user_name", userTmp.getName());
                user.add(mapListUserListTmp);
            }
            mapListTmp.put("user",user);
            mapList.add(mapListTmp);
        }
        return mapList;
    }
}