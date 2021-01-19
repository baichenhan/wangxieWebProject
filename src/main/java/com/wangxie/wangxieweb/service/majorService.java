package com.wangxie.wangxieweb.service;


import com.wangxie.wangxieweb.entity.Major;
import com.wangxie.wangxieweb.entity.MajorShow;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface majorService {
    List<Major> getAllMajor();
    List<Map> getCollegeList();
    List<MajorShow> getCollegeAndMajorList();
}
