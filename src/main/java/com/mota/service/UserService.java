package com.mota.service;

import com.mota.bean.User;

import java.util.List;

public interface UserService {

    User userInfo(String username);

    List<User> queryList(User user);

    void updateUser(User user);

    void saveUser(User user);

    void deleteUser(User user);
}
