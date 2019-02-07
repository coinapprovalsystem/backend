

package com.me.spring.jackson.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置Jackson
 *
 * @author zhaohaojie
 * @date 2018-4-9 上午12:10
 */
@Configuration
@ConditionalOnResource(resources = {"META-INF/services/com.fasterxml.jackson.databind.Module"})
public class JacksonAutoConfiguration {

    /**
     * 通过JDK的ServiceLoader机制来寻找Jackson的modules
     */
    @Bean
    Jackson2ObjectMapperBuilderCustomizer customizeJacksonModules(){
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.findModulesViaServiceLoader(true);
    }
}
