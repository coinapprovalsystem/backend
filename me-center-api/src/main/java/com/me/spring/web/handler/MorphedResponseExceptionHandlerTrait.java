/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler;

import com.me.spring.web.handler.wrapper.MorphedResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

/**
 * Trait接口，封装一些通用方法。
 *
 * @author zhaohaojie
 * @date 2018-7-3 下午5:36
 */
public interface MorphedResponseExceptionHandlerTrait {

    /**
     * 处理异常信息
     *
     * @param errno   错误编号
     * @param error   错误信息
     * @param data    附加数据
     * @param request 请求对象
     * @return        异常处理结果
     */
    default ResponseEntity<Object> handleException(int errno, String error, Object data, WebRequest request) {
        MorphedResult morphedResult =
                data == null ? MorphedResult.failure(errno, error) : MorphedResult.failure(errno, error, data);

        return new ResponseEntity<>(morphedResult, HttpStatus.OK);
    }
}
