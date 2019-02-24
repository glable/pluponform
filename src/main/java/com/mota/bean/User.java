package com.mota.bean;

import com.mota.bean.common.BaseEntity;

/**
 * 用户实体类
 */
public class User extends BaseEntity {

    private Long user_id;
    private String name;
    private Integer age;
    private String username;
    private String password;
    private String appid;
    private int status;
    private String token;
    private String yzmid;
    private String hdid;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getYzmid() {
        return yzmid;
    }

    public void setYzmid(String yzmid) {
        this.yzmid = yzmid;
    }

    public String getHdid() {
        return hdid;
    }

    public void setHdid(String hdid) {
        this.hdid = hdid;
    }
}
