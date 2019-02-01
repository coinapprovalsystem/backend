/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.me.spring.web.handler.annotation.EnableMorphedResponse;
import com.me.spring.web.handler.wrapper.MorphedException;
import com.me.spring.web.handler.wrapper.MorphedResult;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 注册自定义的返回结果包装Bean
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午10:22:00
 */
public class MorphedImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     */
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注册Bean
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        if (importingClassMetadata.isAnnotated(EnableMorphedResponse.class.getName())) {
            Map<String, Object> attributes = importingClassMetadata.getAnnotationAttributes(EnableMorphedResponse.class.getName());

            if (attributes.get("handleReturnValue").equals(Boolean.TRUE)) {
                BeanDefinitionBuilder morphedMethodReturnValueBeanDefinition
                        = BeanDefinitionBuilder.rootBeanDefinition(MorphedMethodReturnValueHandlerInjectionFactoryBean.class);
                registry.registerBeanDefinition(MorphedMethodReturnValueHandlerInjectionFactoryBean.class.getName(),
                        morphedMethodReturnValueBeanDefinition.getBeanDefinition());
            }

            if (attributes.get("handleException").equals(Boolean.TRUE)) {
                BeanDefinitionBuilder morphedResponseExceptionHandlerBeanDefinition
                        = BeanDefinitionBuilder.rootBeanDefinition(MorphedResponseExceptionHandlerInjectionFactoryBean.class);
                registry.registerBeanDefinition(MorphedResponseExceptionHandlerInjectionFactoryBean.class.getName(),
                        morphedResponseExceptionHandlerBeanDefinition.getBeanDefinition());
            }

            for (Field field : MorphedResult.class.getDeclaredFields()) {
                try {
                    if (field.getName().equals("code")) {
                        modifyJsonProperty(field, (String) attributes.get("codeAlias"));
                    }
                    if (field.getName().equals("message")) {
                        modifyJsonProperty(field, (String) attributes.get("messageAlias"));
                    }
                    if (field.getName().equals("data")) {
                        modifyJsonProperty(field, (String) attributes.get("dataAlias"));
                    }
                } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
                    throw new MorphedException("修改默认值错误");
                }
            }
        }
    }

    /**
     * 修改{@code JsonProperty}注解的属性值。
     *
     * @param field 被注解的字段
     * @param value 新的属性值
     */
    private void modifyJsonProperty(Field field, String value) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        JsonProperty jsonProperty = field.getAnnotation(JsonProperty.class);
        if (jsonProperty != null && !value.isEmpty()) {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(jsonProperty);
            Field annotationAttribute = invocationHandler.getClass().getDeclaredField("memberValues");
            annotationAttribute.setAccessible(true);
            PropertyUtils.setProperty(annotationAttribute.get(invocationHandler), "value", value);

            logger.info("修改MorphedResult.{}为{}", field.getName(), value);
        }
    }
}
