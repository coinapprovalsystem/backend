/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler;

import com.me.spring.web.handler.wrapper.MorphedCode;
import com.me.spring.web.handler.wrapper.MorphedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolationException;
import java.sql.SQLException;

/**
 * 处理全局异常
 *
 * @author zhaohaojie
 * @date   2018-3-6 下午7:10
 */
@RestControllerAdvice
abstract public class MorphedResponseExceptionHandler extends ResponseEntityExceptionHandler implements MorphedResponseExceptionHandlerTrait {

    /**
     *
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     *
     * @see ResponseEntityExceptionHandler#handleExceptionInternal
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.warn("{}", ex.getMessage());

        return handleException(MorphedCode.FAILURE_HTTP + status.value(), ex.getMessage(), null, request);
    }

    /**
     * 处理ServletException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {ServletException.class})
    protected final ResponseEntity<Object> handleServletException(ServletException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_SERVLET, ex.getMessage(), null, request);
    }

    /**
     * 处理SQLException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {SQLException.class})
    protected final ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_DB, ex.getMessage(), null, request);
    }

    /**
     * 处理ConstraintViolationException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected final ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        logger.error("{}", ex);

        String message = ex.getMessage();
        if (ex.getConstraintViolations() != null && !ex.getConstraintViolations().isEmpty()) {
            message = ex.getConstraintViolations().stream().findFirst().isPresent()
                    ? ex.getConstraintViolations().stream().findFirst().get().getMessage() : null;
        }

        return handleException(MorphedCode.FAILURE_VALIDATION, message, null, request);
    }

    /**
     * 处理MorphedException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {MorphedException.class})
    protected final ResponseEntity<Object> handleMorphedException(MorphedException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(ex.getCode(), ex.getMessage(), ex.getData(), request);
    }

    /**
     * 处理RuntimeException
     *
     * @param ex      异常
     * @param request 请求对象
     * @return        异常处理结果
     */
    @ExceptionHandler(value = {RuntimeException.class})
    protected final ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {
        logger.error("{}", ex);

        return handleException(MorphedCode.FAILURE_UNKNOWN, ex.getMessage(), null, request);
    }
}
