package com.dylan.maven.dao.mapper;

import com.dylan.maven.data.entity.User;

public interface UserMapper {
    User getUserByKid(String kid);
}
