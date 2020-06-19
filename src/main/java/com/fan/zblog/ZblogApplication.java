package com.fan.zblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.fan.zblog.mapper")
@SpringBootApplication
public class ZblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZblogApplication.class, args);
    }

}
