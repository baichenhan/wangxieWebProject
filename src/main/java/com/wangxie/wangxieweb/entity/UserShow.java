package com.wangxie.wangxieweb.entity;

import java.util.List;

public class UserShow {//xxxShow，前台接口所要求的数据结构，可以使用临时的List+Map实现，也可像这样直接声明一个类。
    public int code;
    public String msg;
    public int count;
    public List<UserData> data;
}
