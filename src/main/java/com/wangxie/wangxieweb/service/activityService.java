package com.wangxie.wangxieweb.service;


import com.wangxie.wangxieweb.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface activityService {
    Map getAllActivity();
    Boolean addActivity(Activity activity);
    Boolean deleteActivityById(Integer id);
    Activity findActivityById(Integer id);
    Boolean editActivityByActivity(Activity activity);
}
