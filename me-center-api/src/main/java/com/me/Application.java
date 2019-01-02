package com.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

/**
 * 启动类
 * @SpringBootApplication 标记后
 * @author zhaohaojie
 * @date 2018-12-29 11:47
 */
@SpringBootApplication
@MapperScan(basePackages = "com.me.mysql.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

