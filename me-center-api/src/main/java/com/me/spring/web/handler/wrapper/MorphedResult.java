/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler.wrapper;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回给客户端的结果
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午9:54:00
 */
@Setter
@Getter
public class MorphedResult<T> {

    /**
     * 编号
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 信息
     */
    @JsonProperty("message")
    private String message;

    /**
     * 数据
     */
    @JsonProperty("data")
    private T data;

    /**
     * 额外属性集
     */
    private Map<String, Object> extraProperties = new HashMap<>();

    /**
     * 成功
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return     包装后的结果
     */
    public static <T> MorphedResult<T> success(T data)
    {
        return build(MorphedCode.SUCCESS, "", data);
    }

    /**
     * 失败
     *
     * @param code    编号
     * @param message 信息
     * @param <T>     数据类型
     * @return        包装后的结果
     */
    public static <T> MorphedResult<T> failure(Integer code, String message)
    {
        return build(code, message, null);
    }

    /**
     * 失败
     *
     * @param code    编号
     * @param message 信息
     * @param data    数据
     * @param <T>     数据类型
     * @return        包装后的结果
     */
    public static <T> MorphedResult<T> failure(Integer code, String message, T data)
    {
        return build(code, message, data);
    }

    /**
     * 产生一个对象
     *
     * @param code    编号
     * @param message 信息
     * @param data    数据
     * @param <T>     数据类型
     * @return        包装后的结果
     */
    public static <T> MorphedResult<T> build(Integer code, String message, T data)
    {
        return new MorphedResult<>(code, message, data);
    }

    /**
     * 构造函数
     *
     * @param code    编号
     * @param message 信息
     * @param data    数据
     */
    public MorphedResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回额外属性集
     */
    @JsonAnyGetter
    public Map<String, Object> getExtraProperties() {
        return extraProperties;
    }

    /**
     * 设置额外属性集
     */
    public void setExtraProperties(Map<String, Object> extraProperties) {
        this.extraProperties = extraProperties;
    }

    /**
     * 添加额外属性
     *
     * @param  name  属性名称
     * @param  value 属性值
     * @return       对象本身
     */
    public MorphedResult<T> extra(String name, Object value) {
        extraProperties.put(name, value);

        return this;
    }
}
