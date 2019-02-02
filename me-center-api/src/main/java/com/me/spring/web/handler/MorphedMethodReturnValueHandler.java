package com.me.spring.web.handler;

import com.me.spring.web.handler.annotation.MorphedResponse;
import com.me.spring.web.handler.wrapper.MorphedException;
import com.me.spring.web.handler.wrapper.MorphedResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 对控制器方法的返回值进行处理
 *
 * @author zhaohaojie
 * @date   2018-3-6 上午10:11:00
 */
public class MorphedMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    /**
     * 原有的返回值处理类
     */
    private final HandlerMethodReturnValueHandler delegateValueHandler;

    /**
     * 用来缓存返回值方法是否拥有{@link MorphedResponse}注解
     *
     * @see #supportsReturnType
     */
    private Map<MethodParameter, MorphedResponse> supportMorphedAnnotations;

    /**
     * 构造函数
     *
     * @param delegateValueHandler 原有的返回值处理类
     * @param handlerMapping       URL地址与控制器方法的映射关系
     */
    public MorphedMethodReturnValueHandler(HandlerMethodReturnValueHandler delegateValueHandler, RequestMappingHandlerMapping handlerMapping) {
        this.delegateValueHandler = delegateValueHandler;
        this.supportMorphedAnnotations = new HashMap<>(handlerMapping.getHandlerMethods().size());
    }

    /**
     * 方法是否需要处理
     *
     * @see HandlerMethodReturnValueHandler#supportsReturnType
     */
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        if (!supportMorphedAnnotations.containsKey(returnType)) {
            MorphedResponse morphedResponse = null;
            if (AnnotatedElementUtils.hasAnnotation(returnType.getMethod(), MorphedResponse.class)) {
                morphedResponse = AnnotatedElementUtils.findMergedAnnotation(returnType.getMethod(), MorphedResponse.class);
            } else if (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), MorphedResponse.class)) {
                morphedResponse = AnnotatedElementUtils.findMergedAnnotation(returnType.getContainingClass(), MorphedResponse.class);
            }
            if (morphedResponse != null && !morphedResponse.enable()) {
                morphedResponse = null;
            }
            // 这里缓存一下结果
            supportMorphedAnnotations.put(returnType, morphedResponse);
        }

        return delegateValueHandler.supportsReturnType(returnType) || isMorphedAnnotated(returnType);
    }

    /**
     * 处理返回值
     *
     * @see HandlerMethodReturnValueHandler#handleReturnValue
     */
    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        if (isMorphedAnnotated(returnType)) {
            if (!(returnValue instanceof MorphedResult)) {
                MorphedResponse morphedResponse = supportMorphedAnnotations.get(returnType);
                if (morphedResponse.successCode() != 0 || !morphedResponse.successMessage().isEmpty()) {
                    returnValue = MorphedResult.build(morphedResponse.successCode(), morphedResponse.successMessage(), returnValue);
                } else {
                    returnValue = MorphedResult.success(returnValue);
                }

                if (morphedResponse.extraProperties().length > 0) {
                    for (MorphedResponse.ExtraProperty extraProperty : morphedResponse.extraProperties()) {
                        if (!extraProperty.classType().isPrimitive()) {
                            Object value = extraProperty.classType()
                                    .getMethod("valueOf", String.class)
                                    .invoke(null, extraProperty.defaultValue());
                            ((MorphedResult) returnValue).extra(extraProperty.name(), value);
                        } else {
                            throw new MorphedException("额外属性不支持基本类型");
                        }
                    }
                }
            }
        }
        delegateValueHandler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    }

    /**
     * 判断返回值所在方法是否拥有{@link MorphedResponse}注解
     *
     * @param returnType 返回值原型
     * @return           是否拥有注解
     */
    protected boolean isMorphedAnnotated(MethodParameter returnType) {
        return supportMorphedAnnotations.containsKey(returnType) && supportMorphedAnnotations.get(returnType) != null;
    }
}
