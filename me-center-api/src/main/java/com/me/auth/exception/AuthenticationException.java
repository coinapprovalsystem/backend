package com.me.auth.exception;

/**
 * @author zhaohaojie
 * @date 2019-01-13 20:18
 */
public class AuthenticationException extends SecurityException {

    public AuthenticationException(String message){
        super(message);
    }
}

