package com.dylan.maven.server.springsecurity.controlelr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Dylan
 * @Date 2023/8/27
 */

@RestController
public class TestController {

    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }
}
