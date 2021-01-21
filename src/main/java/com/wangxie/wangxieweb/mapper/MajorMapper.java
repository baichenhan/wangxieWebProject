package com.wangxie.wangxieweb.mapper;

import com.wangxie.wangxieweb.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {
    List<Major> getAllMajor();
    List<Major> getAllCollege();
    int findMajorIdByName(String name);
    String findCollegeByMajorId(int id);
    String findMajorById(int id);
    int findCollegeIdByMajorId(int id);
}
