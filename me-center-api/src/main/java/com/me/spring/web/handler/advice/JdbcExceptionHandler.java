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
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * 处理JDBC异常
 *
 * @author zhaohaojie
 * @date 2018-5-7 下午5:10
 */
@RestControllerAdvice
@ConditionalOnClass(BadSqlGrammarException.class)
public class JdbcExceptionHandler extends MorphedResponseExceptionHandlerAbstract {

    /**
     * 处理BadSqlGrammarException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {BadSqlGrammarException.class})
    protected final ResponseEntity<Object> handleBadSqlGrammarException(BadSqlGrammarException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_DB, ex.getCause().getMessage(), null, request);
    }
}
