/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CORS(跨域资源共享)自动配置
 *
 * @author zhaohaojie
 * @date 2018-4-24 上午10:14
 */
@Configuration
@EnableConfigurationProperties(HttpCorsProperties.class)
@ConditionalOnProperty(prefix = HttpCorsProperties.PREFIX, name = "allowed-origins[0]")
public class HttpCorsAutoConfiguration {

    /**
     *
     */
    private HttpCorsProperties httpCorsProperties;

    /**
     * 构造函数
     */
    public HttpCorsAutoConfiguration(HttpCorsProperties httpCorsProperties) {
        this.httpCorsProperties = httpCorsProperties;
    }

    /**
     * 创建CORS(跨域资源共享)过滤器
     *
     * @return 过滤器对象
     */
    @Bean
    public FilterRegistrationBean getCorsFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CorsSupportFilter(httpCorsProperties));

        return filterRegistrationBean;
    }
}
