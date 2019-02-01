/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler.annotation;

import com.me.spring.web.handler.wrapper.MorphedCode;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * 修改控制器返回给客户端的结果，用{@code MorphedResult}格式来包装。
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午10:03:00
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ResponseBody
public @interface MorphedResponse {

    /**
     *
     */
    boolean enable() default true;

    /**
     * 成功返回的code值
     */
    int successCode() default MorphedCode.SUCCESS;

    /**
     * 成功返回的message值
     */
    String successMessage() default "";

    /**
     * 定义额外属性
     */
    ExtraProperty[] extraProperties() default {};

    /**
     *
     */
    @interface ExtraProperty {

        /**
         * 属性名称
         */
        String name();

        /**
         * 属性类型
         */
        Class<?> classType();

        /**
         * 属性默认值
         */
        String defaultValue();
    }
}
