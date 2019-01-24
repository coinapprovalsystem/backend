package com.me.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 秒杀异常类
 *
 * @author zhaohaojie
 * @date 2019-01-24 17:59
 */
@Getter
@Setter
public class SeckillException extends RuntimeException {

    private String message;
    private Integer code;

    public SeckillException(String message) {
        super(message);
        this.message =message;
        this.code = code;
    }

    public SeckillException(String message, Integer code) {
        super(message);
        this.message =message;
        this.code = code;
    }
}

