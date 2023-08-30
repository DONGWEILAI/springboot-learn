package com.dylan.maven.dao;

import com.dylan.maven.dao.mapper.UserMapper;
import com.dylan.maven.data.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MavenDaoApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void testMapper(){
        User userByKid = userMapper.getUserByKid("1");
        System.out.println(userByKid);
    }

}
