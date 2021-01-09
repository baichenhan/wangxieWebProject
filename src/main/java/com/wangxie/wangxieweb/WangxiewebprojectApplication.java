package com.wangxie.wangxieweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.wangxie.wangxieweb.mapper")//使用MapperScan批量扫描所有的Mapper接口；
public class WangxiewebprojectApplication {//整个项目的启动类

    public static void main(String[] args) {
        SpringApplication.run(WangxiewebprojectApplication.class, args);
    }

}
