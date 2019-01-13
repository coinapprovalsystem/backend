package com.me.auth.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthenticationParam {
    @AliasFor("value")
    String userEmail() default "";
    @AliasFor("userEmail")
    String value() default "";
}
