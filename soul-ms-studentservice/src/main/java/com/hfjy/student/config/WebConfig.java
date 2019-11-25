package com.hfjy.student.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hfjy.student.interceptor.MainInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hsx
 * create at 2019-06-21
 */
@Slf4j
@Configuration
public class WebConfig implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * webmvc配置
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        //配置加载拦截器
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MainInterceptor());
            }
        };
    }


    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder){
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        /** 所有对象都将按如下的规则进行序列化
         * Include.Include.ALWAYS 默认
         * Include.NON_DEFAULT 属性为默认值的不序列化
         * Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，即不返回该字段
         * Include.NON_NULL 属性为NULL 不序列化,就是为null的字段不参加序列化 **/
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
