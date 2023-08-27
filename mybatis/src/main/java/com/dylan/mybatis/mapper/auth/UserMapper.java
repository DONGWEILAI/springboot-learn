package com.dylan.mybatis.mapper.auth;

import com.dylan.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    List<User> getAllUsers();
    User getUserByKid(String kid);

    int addUser(User user);
    int addUserBatch(List<User> userList);

    int updateUser(User user);

    int deleteUserByKid(String kid);
    int deleteUsersBatch(List<String> kids);

    List<User> getByCondition1(Map<String, String> map);
    List<User> getByCondition2(Map<String, String> map);
}
