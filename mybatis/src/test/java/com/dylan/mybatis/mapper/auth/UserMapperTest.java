package com.dylan.mybatis.mapper.auth;

import com.dylan.mybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void getAllUsers() {
        System.out.println(userMapper.getAllUsers());
    }

    @Test
    void getUserByKid() {
        System.out.println(userMapper.getUserByKid("1"));
    }

    @Test
    void getUserByCondition1(){
        HashMap<String, String> m = new HashMap<>();
        m.put("gender", "1");
        m.put("username", "李四");
        List<User> byCondition1 = userMapper.getByCondition1(m);
        System.out.println(byCondition1);
    }

    @Test
    void getUserByCondition2(){
        HashMap<String, String> m = new HashMap<>();
        m.put("username", "李四");
        List<User> byCondition2 = userMapper.getByCondition2(m);
        System.out.println(byCondition2);
    }

    @Test
    void addUser(){
        User u = new User("433","tom", "45322", 0, null, 0);
        System.out.println(userMapper.addUser(u));
    }

    @Test
    void addUserBatch(){
        List<User> list = Arrays.asList(new User("111", "tom", "45322", 0, null, 0),
                new User("222", "tom", "45322", 0, null, 0));
        System.out.println(userMapper.addUserBatch(list));
    }

    @Test
    void updateUser(){
        User u = userMapper.getUserByKid("1");
        u.setGender(1);
        System.out.println(userMapper.updateUser(u));
    }

    @Test
    void deleteUser(){
        System.out.println(userMapper.deleteUserByKid("43"));
    }

    @Test
    void deleteUserBatch(){
        System.out.println(userMapper.deleteUsersBatch(Arrays.asList("433", "111")));
    }

}