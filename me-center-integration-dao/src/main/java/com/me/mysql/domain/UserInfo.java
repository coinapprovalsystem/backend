package com.me.mysql.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaohaojie
 * @date 2018-12-29 14:18
 */
@Getter
@Setter
public class UserInfo {

    private Integer userId;
    private String username;
    private String password;
}

