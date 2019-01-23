package com.me.configuration;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.entity.Student;
import com.me.mysql.domain.GoodsInfo;
import com.me.mysql.domain.UserInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试数据源
 *
 * @author zhaohaojie
 * @date 2018-12-29 17:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DBConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Student student;

    @Test
    public void testConnection(){
        try {
            System.out.println(dataSource.getClass());
            Connection connection = dataSource.getConnection();
            System.out.println(connection.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConfiguration() throws JsonProcessingException {
    }
}

