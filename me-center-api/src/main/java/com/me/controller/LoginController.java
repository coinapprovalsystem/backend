package com.me.controller;

import com.me.auth.annotation.AuthenticationParam;
import com.me.auth.annotation.SkipAuthentication;
import com.me.mysql.domain.User;
import com.me.mysql.domain.UserInfo;
import com.me.service.UserInfoService;
import com.me.service.UserService;
import com.me.spring.web.handler.annotation.MorphedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * login controller
 *
 * @author zhaohaojie
 * @date 2018-12-29 14:15
 */
@RestController
@MorphedResponse
@RequestMapping(value = "/me/center")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserService userService;

    @GetMapping("/login/{id}")
    @SkipAuthentication
    public UserInfo login(@PathVariable("id") Integer id, @AuthenticationParam String userEmail){
        return userInfoService.getUserInfo(id);
    }

    @PostMapping("/register")
    @SkipAuthentication
    public void register(@RequestBody User user) {
        userService.register(user);
    }

    @GetMapping("/userlist")
    @SkipAuthentication
    public List<User> userList() {
        return userService.getUserList();
    }
}

