package com.dylan.maven.api.service;

import com.dylan.maven.data.entity.User;

public interface UserService {
    User getUserByKid(String kid);
}