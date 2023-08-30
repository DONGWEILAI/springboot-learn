package com.dylan.maven.server.service;

import com.dylan.maven.api.service.UserService;
import com.dylan.maven.dao.mapper.UserMapper;
import com.dylan.maven.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dylan.maven.common.util.UUIDUtil;

/**
 * @Author Dylan
 * @Date 2023/8/29
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByKid(String kid) {
        String uuid = UUIDUtil.generateUUID32();
        System.out.println(uuid);

        return userMapper.getUserByKid(kid);
    }
}
