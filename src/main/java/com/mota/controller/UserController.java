package com.mota.controller;


import com.alibaba.fastjson.JSON;
import com.mota.bean.AccountInfo;
import com.mota.bean.User;
import com.mota.bean.YyReport;
import com.mota.bean.common.PageEntity;
import com.mota.service.SdkService;
import com.mota.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @Autowired
    public SdkService sdkService;

    @Autowired
    public UserService userService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public Object login(@RequestBody User user, HttpSession session) {
        if (null != user && user.getUsername().equals("admin")) {
            session.setAttribute("username", user.getUsername());
            return JSON.parse("{\"code\":20000,\"data\":{\"token\":\"admin\"}}");
        }
        session.setAttribute("username", user.getUsername());
        return JSON.parse("{\"code\":20000,\"data\":{\"token\":\"general\"}}");
    }

    @RequestMapping(value = {"/info"}, method = RequestMethod.GET)
    public Object info(@RequestParam(value = "token", required = false) String token) {
        if (token.equals("admin")) {
            return JSON.parse("{\"code\":20000,\"data\":{\"roles\":[\"admin\"],\"name\":\"admin\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"}}");
        }
        return JSON.parse("{\"code\":20000,\"data\":{\"roles\":[\"general\"],\"name\":\"general\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"}}");
    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public Object logout(HttpSession session) {
        session.removeAttribute("attribute");
        return JSON.parse("{\"code\":20000,\"data\":{\"roles\":[\"admin\"],\"name\":\"admin\",\"avatar\":\"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif\"}}");
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postUser(@RequestBody User user) {
        users.put(user.getUser_id(), user);
        return "success";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @RequestBody User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

    @RequestMapping(value = "/account/list", method = RequestMethod.GET)
    public Object accountList() {
        List<AccountInfo> data = new ArrayList<AccountInfo>();
        AccountInfo accountInfo = sdkService.accountInfo();
//        sdkService.billRecords("8aaf07086772ac61016773b46d42025b");
//        sdkService.billRecords("8aaf070857418a580157454de2d201a5");
        data.add(accountInfo);
        Map<String, Object> result = new HashMap();
        result.put("code", 20000l);
        result.put("data", data);
        return result;
    }

    @RequestMapping("/userList")
    public Object userList(User user) {
        List<User> userList = userService.queryList(user);
        Map<String, Object> result = new HashMap();
        result.put("code", 20000l);
        result.put("data", new PageEntity<>(userList));
        return result;
    }

    @RequestMapping("/addUser")
    public Object addUser(User user) {
        long resultCode = 20000l;
        String message = "新增用户成功！";
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            resultCode = 0l;
            message = "新增用户失败！" + e.getMessage();
        }
        Map<String, Object> result = new HashMap();
        result.put("code", resultCode);
        result.put("data", message);
        return result;
    }

    @RequestMapping("/editUser")
    public Object editUser(User user) {
        long resultCode = 20000l;
        String message = "编辑用户成功！";
        try {
            userService.updateUser(user);
        } catch (Exception e) {
            resultCode = 0l;
            message = "编辑用户失败！" + e.getMessage();
        }
        Map<String, Object> result = new HashMap();
        result.put("code", resultCode);
        result.put("data", message);
        return result;
    }

    @RequestMapping("/deleteUser")
    public Object deleteUser(User user) {
        long resultCode = 20000l;
        String message = "删除用户成功！";
        try {
            userService.deleteUser(user);
        } catch (Exception e) {
            resultCode = 0l;
            message = "删除用户失败！" + e.getMessage();
        }
        Map<String, Object> result = new HashMap();
        result.put("code", resultCode);
        result.put("data", message);
        return result;
    }

}