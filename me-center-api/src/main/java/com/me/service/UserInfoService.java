package com.me.service;

import com.me.mysql.domain.UserInfo;
import com.me.mysql.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 服务类
 *
 * @author zhaohaojie
 * @date 2018-12-30 0:33
 */
@Service
public class UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo(Integer id){
        return userInfoMapper.getUserInfo(id);
    }
}

