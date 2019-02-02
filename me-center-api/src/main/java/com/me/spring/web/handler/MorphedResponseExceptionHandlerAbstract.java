

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
