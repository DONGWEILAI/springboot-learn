package com.dylan.maven.server.basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@RestController
@RequestMapping("yml")
public class ymlTestController {
    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${base.config.name}")
    private String baseConfigName;

    @Value("${base.config.port}")
    private String baseConfigPort;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/")
    public void test(){
        System.out.println("applicationName: " + applicationName);
        System.out.println("base.config.name: " + baseConfigName);
        System.out.println("base.config.name: " + baseConfigPort);
        System.out.println("server.port: " + serverPort);
    }



}
