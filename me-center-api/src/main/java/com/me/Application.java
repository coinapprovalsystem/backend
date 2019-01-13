package com.me;

import com.me.auth.annotation.EnableAuthentication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 启动类
 * @SpringBootApplication 标记后
 * @author zhaohaojie
 * @date 2018-12-29 11:47
 */
@SpringBootApplication
@EnableAuthentication
@MapperScan(basePackages = "com.me.mysql.mapper")
public class Application {

    public static void main(String[] args) {
        //获取调用栈的数组，并且获取对应的方法和类名，获取的方式应该就是将this传入，获取的方式就是通过回调函数
//        StackTraceElement[] element = (new RuntimeException()).getStackTrace();
//        element[0].getMethodName();
        SpringApplication.run(Application.class,args);
    }
}

