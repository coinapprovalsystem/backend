package com.me.auth.handler;

import com.me.auth.annotation.AuthenticationParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器方法参数解析器
 * 通过注解的方式，在controller层获取身份认证信息
 * @author zhaohaojie
 * @date 2019-01-13 14:46
 */
public class AuthenticationArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 有这个注解修饰的参数上，才做解析 与 后处理
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(AuthenticationParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest httpServletRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String userEmail = httpServletRequest.getHeader(AuthenticationInterceptor.USER_EMAIL);
        if (StringUtils.isNoneBlank(userEmail)){
            //TODO　加密数据 解析
        }
        return userEmail;
    }
}

