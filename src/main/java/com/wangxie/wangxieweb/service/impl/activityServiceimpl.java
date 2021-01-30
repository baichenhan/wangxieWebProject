package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.entity.Activity;
import com.wangxie.wangxieweb.mapper.UserMapper;
import com.wangxie.wangxieweb.service.activityService;
import com.wangxie.wangxieweb.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("activityService")
public class activityServiceimpl implements activityService{

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Map getAllActivity() {
        List<Activity> result = activityMapper.getAllActivity();
        for(Activity activity : result) {
            String[] ids = activity.getParticipantId().split(",");
            String participant = "";
            for(String str : ids) {
                participant += userMapper.findNameById(Integer.parseInt(str));
                participant += ",";
            }
            if(!participant.equals(""))
                participant = participant.substring(0, participant.length()-1);
                activity.setParticipantId(participant);
        }
        Map map = new HashMap<>();
        map.put("code", 0);
        map.put("message", "成功！");
        map.put("count", result.size());
        map.put("data", result);
        return map;
    }

    @Override
    public Boolean addActivity(Activity activity) {
        return activityMapper.addActivity(activity) != 0;
    }

    @Override
    public Boolean deleteActivityById(Integer id) {
        return activityMapper.deleteActivityById(id) != 0;
    }

    @Override
    public Activity findActivityById(Integer id) {
        Activity activity = activityMapper.findActivityById(id);
        String[] ids = activity.getParticipantId().split(",");
        String participant = "";
        for(String str : ids) {
            participant += userMapper.findNameById(Integer.parseInt(str));
            participant += ",";
        }
        if(!participant.equals(""))
            participant = participant.substring(0, participant.length()-1);
        activity.setParticipantId(participant);
        return activity;
    }

    @Override
    public Boolean editActivityByActivity(Activity activity) {
       return activityMapper.editActivityByActivity(activity) != 0;
    }
}
