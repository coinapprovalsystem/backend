package com.me.common;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.mysql.domain.GoodsInfo;
import com.me.mysql.domain.UserInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohaojie
 * @date 2019-01-18 12:00
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class Object2StringTest {

    @Autowired
    private Jackson2ObjectMapperBuilder j2oBuilder;
    @Test
    public void testSerialize() throws JsonProcessingException {
        Integer id  = 12;
        //object
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodsId(id);
        goodsInfo.setGoodsName("巧克力");
        //UserInfo
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword("12211");
        userInfo.setUserId(12);
//        userInfo.setUsername("jack");
        //list
        List<String> list = new ArrayList<String>();
        list.add("小明");
        list.add("效力");

        ObjectMapper objectMapper = j2oBuilder.build();
        System.out.println(objectMapper.writeValueAsString(goodsInfo));
        System.out.println("=================");
        System.out.println(JSONObject.toJSONString(goodsInfo));
        System.out.println("=================");
        System.out.println(ToStringBuilder.reflectionToString(goodsInfo));
        System.out.println(goodsInfo.toString());
        System.out.println("((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
        System.out.println(objectMapper.writeValueAsString(userInfo));
        System.out.println("=================");
        System.out.println(JSONObject.toJSONString(userInfo));//有序，去空，
        System.out.println("=================");
        System.out.println(ToStringBuilder.reflectionToString(userInfo));//哈希
    }
}

