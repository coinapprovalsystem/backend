package com.me.service;

import com.me.mysql.domain.User;
import com.me.mysql.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }
}
