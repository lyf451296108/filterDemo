package com.filter.filterDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.filter.filterDemo.interceptor.RequestHeaderContextInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

    @Bean
    public RequestHeaderContextInterceptor requestHeaderContextInterceptor() {
        return new RequestHeaderContextInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestHeaderContextInterceptor()).addPathPatterns("/**");
    }
}	