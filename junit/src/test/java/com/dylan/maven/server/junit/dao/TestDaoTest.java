package com.dylan.maven.server.junit.dao;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestDaoTest {

    @Autowired
    TestDao testDao;

    @BeforeEach
    void welcome() {
        testDao.welcome();
    }

    @AfterEach
    void byeBye() {
        testDao.byeBye();
    }

//    @Test
    @DisplayName("随机获取值")
    @RepeatedTest(2)
    void getRandomNum() {
        int randomNum = testDao.getRandomNum();
        System.out.println(randomNum);
    }

    @Test
    @DisplayName("随机获取值2")
    @Disabled
    void getRandomNum2() {
        int randomNum = testDao.getRandomNum();
        System.out.println(randomNum);
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("AfterAll");
    }
}