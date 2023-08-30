package com.dylan.maven.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.dylan.maven.dao.mapper")
@SpringBootApplication
public class MavenDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenDaoApplication.class, args);
    }

}
