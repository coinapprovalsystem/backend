package com.me.configuration;

import com.me.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaohaojie
 * @date 2019-02-06 20:07
 */
@Configuration
public class ServletConfiguration {

    @Bean
    public ServletRegistrationBean registerBean(){
        return new ServletRegistrationBean(new TestServlet(),"/servlet/*");
    }
}

