package com.me.mysql.mapper;

import com.me.mysql.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * userInfo interface
 *
 * @author zhaohaojie
 * @date 2018-12-29 22:05
 */
@Mapper
public interface UserInfoMapper {

    @Select("select * from userInfo where userId = #{id}")
    public UserInfo getUserInfo(Integer id);

    @Insert("insert into userInfo(")
    public UserInfo insertUserInfo(UserInfo userInfo);
}

