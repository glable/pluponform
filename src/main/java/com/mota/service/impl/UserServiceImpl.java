package com.mota.service.impl;

import com.mota.bean.User;
import com.mota.dao.UserDao;
import com.mota.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User userInfo(String username) {
        return userDao.userInfo(username);
    }

    @Override
    public List<User> queryList(User user) {
        return userDao.queryList(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void saveUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}
