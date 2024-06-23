package com.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//指示声明一个或多个@Bean方法并触发自动配置和组件扫描的配置类
@MapperScan("com.forum.mapper")
public class UniForumApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniForumApplication.class, args);
    }

}
