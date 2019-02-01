/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 全局异常处理抽象类
 *
 * @author zhaohaojie
 * @date 2018-4-23 下午4:11
 */
abstract public class MorphedResponseExceptionHandlerAbstract implements MorphedResponseExceptionHandlerTrait {

    /**
     *
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
