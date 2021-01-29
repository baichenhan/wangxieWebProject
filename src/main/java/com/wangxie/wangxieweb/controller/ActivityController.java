package com.wangxie.wangxieweb.controller;


import com.wangxie.wangxieweb.entity.Activity;
import com.wangxie.wangxieweb.service.activityService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private activityService activityService;

    @RequestMapping(value = "/addActivity", method = {RequestMethod.POST, RequestMethod.GET})
    public Map addActivity(@NotNull HttpServletRequest request) {
        Activity activity = new Activity();
        activity.setName(request.getParameter("name"));
        activity.setContent(request.getParameter("content"));
        activity.setDepartment(request.getParameter("department"));
        activity.setStartTime(Timestamp.valueOf(request.getParameter("start_time")));
        activity.setEndTime(Timestamp.valueOf(request.getParameter("end_time")));
        activity.setLeaderUser(request.getParameter("leader_user"));
        activity.setParticipantId(request.getParameter("participant_id"));
        Map map = new HashMap<>();
        if(activityService.addActivity(activity)) {
            map.put("status", 1);
            map.put("message", "添加成功");
        }
        else {
            map.put("status", 0);
            map.put("message", "添加失败");
        }
        return map;
    }

    @RequestMapping("/getAllActivity")
    public Map getAllActivity() {
        return activityService.getAllActivity();
    }
}
