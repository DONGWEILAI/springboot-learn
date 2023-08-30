package com.dylan.maven.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.dylan.maven.dao.mapper")
@SpringBootApplication()
public class MavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenApplication.class, args);
    }

}
