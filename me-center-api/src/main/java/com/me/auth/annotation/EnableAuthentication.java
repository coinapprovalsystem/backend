package com.me.auth.annotation;

import com.me.auth.handler.AuthenticationDefinitionRegistry;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthenticationDefinitionRegistry.class)
@Documented
public @interface EnableAuthentication {
}
