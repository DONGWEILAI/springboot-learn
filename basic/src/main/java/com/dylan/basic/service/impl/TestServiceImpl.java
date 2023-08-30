package com.dylan.basic.service.impl;

import com.dylan.basic.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author Dylan
 * @Date 2023/8/26
 */

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "test";
    }
}
