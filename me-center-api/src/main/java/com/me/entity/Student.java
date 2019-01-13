package com.me.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhaohaojie
 * @date 2019-01-08 20:17
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "Student")
@Component
public class Student implements Comparable<Student>{
    private Integer keyId;
    private String name;
    private String age;

    // 实现自然排序接口，重写compareTo方法，通过keyId
    @Override
    public int compareTo(Student o) {
        return   o.getKeyId()-this.keyId;
    }
}

