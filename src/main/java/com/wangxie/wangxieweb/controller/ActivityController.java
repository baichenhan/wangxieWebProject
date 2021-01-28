package com.wangxie.wangxieweb.controller;


import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @RequestMapping(value = "/addActivity", method = {RequestMethod.POST, RequestMethod.GET})
    public Map addActivity(@NotNull HttpServletRequest request) {

        Map map = new HashMap<>();
        map.put("status", 1);
        map.put("message", "添加失败");
        return map;
    }
}
