package com.wangxie.wangxieweb.mapper;


import com.wangxie.wangxieweb.entity.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    Integer addActivity(Activity activity);
    List<Activity> getAllActivity();
}
