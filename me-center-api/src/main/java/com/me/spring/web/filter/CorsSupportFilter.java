package com.me.spring.web.filter;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 自定义的CORS(跨域资源共享)过滤器
 *
 * @author zhaohaojie
 * @date   2018-3-20 下午01:22:00
 */
public class CorsSupportFilter extends CorsFilter {

    /**
     * 构造函数
     */
    public CorsSupportFilter(HttpCorsProperties properties) {
        super(configurationSource(properties));
    }

    /**
     * 配置过滤规则
     */
    private static UrlBasedCorsConfigurationSource configurationSource(HttpCorsProperties properties) {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.applyPermitDefaultValues();

        if (properties.getAllowedCredentials() != null) {
            corsConfiguration.setAllowCredentials(properties.getAllowedCredentials());
        }
        if (properties.getMaxAge() != null) {
            corsConfiguration.setMaxAge(properties.getMaxAge());
        }

        if (properties.getAllowedMethods() != null) {
            corsConfiguration.setAllowedMethods(properties.getAllowedMethods());
        }

        if (properties.getAllowedHeaders() != null) {
            corsConfiguration.setAllowedHeaders(properties.getAllowedHeaders());
        }

        if (properties.getAllowedOrigins() != null) {
            corsConfiguration.setAllowedOrigins(properties.getAllowedOrigins());
        }

        if (properties.getExposedHeaders() != null) {
            corsConfiguration.setExposedHeaders(properties.getExposedHeaders());
        }

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }
}
