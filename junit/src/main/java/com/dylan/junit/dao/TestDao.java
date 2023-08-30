package com.dylan.junit.dao;

import org.springframework.stereotype.Repository;

import java.util.Random;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@Repository
public class TestDao {

    public void welcome(){
        System.out.println("Welcome");
    }

    public void byeBye(){
        System.out.println("ByeBye!");
    }

    public int getRandomNum(){
        return new Random().nextInt();
    }
}
