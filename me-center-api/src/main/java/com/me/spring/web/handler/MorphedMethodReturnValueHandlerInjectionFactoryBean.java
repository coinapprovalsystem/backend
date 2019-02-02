

package com.me.spring.web.handler;

import com.google.common.collect.Lists;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.List;

/**
 * 注入自定义的控制器返回值处理类
 *
 * @author zhaohaojie
 * @date 2018-3-6 上午10:16:00
 */
public class MorphedMethodReturnValueHandlerInjectionFactoryBean implements InitializingBean, ApplicationContextAware {

    /**
     * {@link RequestMappingHandlerAdapter}
     */
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    /**
     * {@link RequestMappingHandlerMapping}
     */
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    /**
     * 添加自定义的返回值处理器
     *
     * @see InitializingBean#afterPropertiesSet
     */
    @Override
    public void afterPropertiesSet() {
        List<HandlerMethodReturnValueHandler> returnValueHandlers = Lists.newArrayList(requestMappingHandlerAdapter.getReturnValueHandlers());
        for (HandlerMethodReturnValueHandler handler : returnValueHandlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                returnValueHandlers.set(returnValueHandlers.indexOf(handler), new MorphedMethodReturnValueHandler(handler, requestMappingHandlerMapping));
                break;
            }
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(returnValueHandlers);
    }

    /**
     * 注入RequestMappingHandlerAdapter对象
     *
     * @see ApplicationContextAware#setApplicationContext
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        requestMappingHandlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
        requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
    }
}
