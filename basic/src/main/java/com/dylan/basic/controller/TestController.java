package com.dylan.basic.controller;

import com.dylan.basic.entity.Test;
import com.dylan.basic.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    // http://localhost:8080/test/
    @GetMapping("/")
    public String test(){
        return testService.test();
    }

    // http://localhost:8080/test/1
    @GetMapping("/{uid}")
    public String pathVariableTest(@PathVariable(value = "uid", required = false) int id){
        return String.valueOf(id);
    }

    // http://localhost:8080/test/index?id=4
    @GetMapping("/index")
    public String paramTest(@RequestParam int id){
        return String.valueOf(id);
    }

    // post
    @PostMapping("/index")
    public Test requestBodyTest(@RequestBody Test test){
        return test;
    }

    @GetMapping("/demo")
    public void headerAndCookieTest(@RequestHeader(name = "myHeader") String myHeader,
                      @CookieValue(name = "myCookie") String myCookie) {
        System.out.println("myHeader=" + myHeader);
        System.out.println("myCookie=" + myCookie);
    }

    @GetMapping("/demo2")
    public void headerAndCookieTest2(HttpServletRequest request) {
        System.out.println(request.getHeader("myHeader"));
        for (Cookie cookie : request.getCookies()) {
            if ("myCookie".equals(cookie.getName())) {
                System.out.println(cookie.getValue());
            }
        }
    }

}
