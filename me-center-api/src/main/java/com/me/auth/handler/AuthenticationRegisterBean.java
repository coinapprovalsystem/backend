package com.me.auth.handler;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 注册拦截器类
 * 1、注册拦截器
 * 2、添加参数校验
 * @author zhaohaojie
 * @date 2019-01-13 14:26
 */
public class AuthenticationRegisterBean extends WebMvcConfigurerAdapter {

    private AuthenticationArgumentResolver authenticateArgumentResolver;
    private AuthenticationInterceptor authorityInterceptor;

    public AuthenticationRegisterBean(AuthenticationArgumentResolver authenticateArgumentResolver, AuthenticationInterceptor authorityInterceptor) {
        this.authenticateArgumentResolver = authenticateArgumentResolver;
        this.authorityInterceptor = authorityInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration;
        interceptorRegistration = registry.addInterceptor(authorityInterceptor);
        // 拦截配置
        interceptorRegistration.addPathPatterns("/**");
        // 排除配置
        interceptorRegistration.excludePathPatterns("/swagger**");
        interceptorRegistration.excludePathPatterns("/admin**");
        super.addInterceptors(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(authenticateArgumentResolver);
        super.addArgumentResolvers(argumentResolvers);
    }
}

