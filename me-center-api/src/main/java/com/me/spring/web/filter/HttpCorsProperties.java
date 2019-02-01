package com.me.spring.web.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * CORS配置信息
 *
 * @author zhaohaojie
 * @date   2018-3-20 下午01:23:00
 */
@ConfigurationProperties(prefix = HttpCorsProperties.PREFIX)
public class HttpCorsProperties {

    /**
     *
     */
    public final static String PREFIX = "spring.http.cors";

    /**
     * 是否支持证书
     */
    private Boolean allowedCredentials;

    /**
     * 预检的缓存时间，单位秒。
     */
    private Long maxAge;

    /**
     * 允许跨域访问的HTTP请求方式
     */
    private List<String> allowedMethods;

    /**
     * 允许跨域访问的HTTP头
     */
    private List<String> allowedHeaders;

    /**
     * 允许跨域访问的地址
     */
    private List<String> allowedOrigins;

    /**
     * 暴露的HTTP头信息
     */
    private List<String> exposedHeaders;

    public Boolean getAllowedCredentials() {
        return allowedCredentials;
    }

    public void setAllowedCredentials(Boolean allowedCredentials) {
        this.allowedCredentials = allowedCredentials;
    }

    public Long getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Long maxAge) {
        this.maxAge = maxAge;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public List<String> getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(List<String> allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigin) {
        this.allowedOrigins = allowedOrigin;
    }

    public List<String> getExposedHeaders() {
        return exposedHeaders;
    }

    public void setExposedHeaders(List<String> exposedHeaders) {
        this.exposedHeaders = exposedHeaders;
    }
}
