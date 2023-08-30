package com.dylan.maven.server.basic.controller;

import com.dylan.maven.server.basic.config.ConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@RestController
@RequestMapping("/config")
public class ConfigPropertiesController {

    @Autowired
    ConfigProperties configProperties;

    @GetMapping("/")
    public void test(){
        System.out.println("base.config.applicationName: " + configProperties.getApplicationName());
        System.out.println("base.config.name: " + configProperties.getName());
        System.out.println("base.config.port: " + configProperties.getPort());
        System.out.println("base.config.active: " + configProperties.getActive());
    }
}
