package com.wangxie.wangxieweb.service.impl;

import com.wangxie.wangxieweb.entity.Department;
import com.wangxie.wangxieweb.entity.Major;
import com.wangxie.wangxieweb.entity.MajorShow;
import com.wangxie.wangxieweb.mapper.MajorMapper;
import com.wangxie.wangxieweb.service.majorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("majorService")
public class majorServiceimpl implements majorService {

    @Autowired
    private MajorMapper majorMapper;

    @Override
    public List<Major> getAllMajor() {
        return majorMapper.getAllMajor();
    }

    @Override
    public List<Map> getCollegeList() {
        List<Map> map = new ArrayList<>();
        for(Major major : majorMapper.getAllCollege()){
            Map mapTmp = new HashMap<>();
            mapTmp.put("name", major.getName());
            mapTmp.put("value", major.getId().toString());
            map.add(mapTmp);
        }
        return map;
    }

    @Override
    public List<MajorShow> getCollegeAndMajorList() {
        List<MajorShow> map = new ArrayList<>();
        for(Major college : majorMapper.getAllCollege()) {
            MajorShow majorShowTmp = new MajorShow();
            majorShowTmp.value = college.getId().toString();
            majorShowTmp.name = college.getName();
            majorShowTmp.major = new ArrayList<>();
            for(Major major : majorMapper.getAllMajor()) {
                if(major.getPid() == college.getId()){
                    Map mapTmp = new HashMap<>();
                    mapTmp.put("value", major.getId().toString());
                    mapTmp.put("name", major.getName());
                    majorShowTmp.major.add(mapTmp);
                }
            }
            map.add(majorShowTmp);
        }
        return map;
    }
}
