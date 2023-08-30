package com.dylan.maven.server.controller;

import com.dylan.maven.api.service.UserService;
import com.dylan.maven.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{kid}")
    public User getUserByKid(@PathVariable("kid") String kid){
        return userService.getUserByKid("1");
    }
}
