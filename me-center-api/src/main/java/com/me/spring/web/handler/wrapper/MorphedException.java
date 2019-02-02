

package com.me.spring.web.handler.wrapper;

import lombok.Getter;

/**
 * 自定义的用于统一结果返回的异常
 *
 * @author zhaohaojie
 * @date   2018-3-6 下午7:07
 */
@Getter
public class MorphedException extends RuntimeException {

    private static final long serialVersionUID = -5349272317488299888L;

    /**
     * 错误编号
     */
    private Integer code;

    /**
     * 附加数据
     */
    private Object data;

    public MorphedException(String message) {
        super(message);
        this.code = MorphedCode.FAILURE;
    }

    public MorphedException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public MorphedException(String message, Integer code, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }

    public MorphedException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public MorphedException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public MorphedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}

