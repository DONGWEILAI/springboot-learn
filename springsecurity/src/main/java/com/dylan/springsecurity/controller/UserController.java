package com.dylan.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dylan
 * @Date 2023/8/31
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String getAllUsers(){
        return "all";
    }
}
