package com.mota.dao;

import com.mota.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {


    User userInfo(@Param("username") String username);

    List<User> queryList(User user);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}