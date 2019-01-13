package com.me.controller;

import com.me.auth.annotation.AuthenticationParam;
import com.me.mysql.domain.UserInfo;
import com.me.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * login controller
 *
 * @author zhaohaojie
 * @date 2018-12-29 14:15
 */
@RestController
@RequestMapping(value = "/me/center")
public class LoginController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/login/{id}")
    public UserInfo login(@PathVariable("id") Integer id, @AuthenticationParam String userEmail){
        System.out.println("useremail is "+userEmail);
        return userInfoService.getUserInfo(id);
    }
}

