package com.me.auth.handler;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 注册身份认证bean
 *
 * @author zhaohaojie
 * @date 2019-01-12 9:50
 */
public class AuthenticationDefinitionRegistry implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
       //注册拦截器
        BeanDefinitionBuilder authorityInterceptorBuilder = BeanDefinitionBuilder.genericBeanDefinition(AuthenticationInterceptor.class);
        beanDefinitionRegistry.registerBeanDefinition(AuthenticationInterceptor.class.getName(),authorityInterceptorBuilder.getBeanDefinition());
        //注册解析器
        BeanDefinitionBuilder resolverBuilder = BeanDefinitionBuilder.genericBeanDefinition(AuthenticationArgumentResolver.class);
        beanDefinitionRegistry.registerBeanDefinition(AuthenticationArgumentResolver.class.getName(),resolverBuilder.getBeanDefinition());
        //注册自定义bean
        BeanDefinitionBuilder authenticationRegisterBeanBuilder = BeanDefinitionBuilder.genericBeanDefinition(AuthenticationRegisterBean.class);
        beanDefinitionRegistry.registerBeanDefinition(AuthenticationRegisterBean.class.getName(),authenticationRegisterBeanBuilder.getBeanDefinition());
    }
}

