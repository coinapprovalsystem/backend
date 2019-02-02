

package com.me.spring.web.handler.annotation;

import com.me.spring.web.handler.MorphedImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否启用控制器返回结果包装器
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午10:29
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({MorphedImportBeanDefinitionRegistrar.class})
@Documented
public @interface EnableMorphedResponse {

    /**
     * 是否对控制器方法的返回值进行处理
     */
    boolean handleReturnValue() default true;

    /**
     * 是否对抛出的异常进行处理
     */
    boolean handleException() default true;

    /**
     * code参数的别名
     */
    String codeAlias() default "";

    /**
     * message参数的别名
     */
    String messageAlias() default "";

    /**
     * data参数的别名
     */
    String dataAlias() default "";
}
