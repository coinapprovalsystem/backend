/*
 * Copyright 2018 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */

package com.me.spring.web.handler.wrapper;

/**
 * 定义错误编号
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午9:58:00
 */
public final class MorphedCode {

    /**
     * 成功
     */
    public static final int SUCCESS = 0;

    /**
     * 未知错误
     */
    public static final int FAILURE_UNKNOWN = -1;

    /**
     * 900000       : HTTP状态码错误
     * 900001-900999: HTTP状态码详细错误
     *
     * 例如: 500错误，返回900500。
     */
    public static final int FAILURE_HTTP = 900000;

    /**
     * 901000       : 自定义错误
     * 901001-901999: 自定义详细错误
     */
    public static final int FAILURE = 901000;

    // 参数验证错误
    public static final int FAILURE_VALIDATION = 901001;

    // 未登录错误
    public static final int FAILURE_UNAUTHORIZED = 901002;

    // 数据库错误
    public static final int FAILURE_DB = 901100;

    // MySQL错误
    public static final int FAILURE_DB_MYSQL = 901101;

    // SQL Server错误
    public static final int FAILURE_DB_SQLSERVER = 901102;

    // Servlet错误
    public static final int FAILURE_SERVLET = 901200;

    /**
     * 910000       : 外部服务错误
     * 910001-910999: 外部服务详细错误
     */
    public static final int FAILURE_VENDOR = 910000;

    /**
     * 910100        : WCF服务错误
     * 910100-910199 : WCF服务详细错误
     */
    public static final int FAILURE_VENDOR_WCF = 910100;

    /**
     * 910200        : 微信服务错误
     * 910201-910299 : 微信服务详细错误
     */
    public static final int FAILURE_VENDOR_WECHAT = 910200;

    /**
     * 920000以上的错误码保留，供后续使用。
     */
    public static final int FAILURE_EXTRA = 920000;

    /**
     * 构造函数
     */
    public MorphedCode() {
    }
}
