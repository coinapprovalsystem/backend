/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler.advice;

import com.me.spring.web.handler.MorphedResponseExceptionHandlerAbstract;
import com.me.spring.web.handler.wrapper.MorphedCode;
import com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLTransientException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * 处理MySQL异常
 *
 * @author zhaohaojie
 * @date 2018-4-23 下午4:21
 */
@RestControllerAdvice
@ConditionalOnClass({MySQLNonTransientException.class, MySQLTransientException.class})
public class MySQLExceptionHandler extends MorphedResponseExceptionHandlerAbstract {

    /**
     * 处理MySQLNonTransientException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {MySQLNonTransientException.class})
    protected final ResponseEntity<Object> handleMySQLNonTransientException(MySQLNonTransientException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_DB_MYSQL, ex.getMessage(), null, request);
    }

    /**
     * 处理MySQLTransientException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {MySQLTransientException.class})
    protected final ResponseEntity<Object> handleMySQLTransientException(MySQLTransientException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_DB_MYSQL, ex.getMessage(), null, request);
    }
}
