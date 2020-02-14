package com.antiy.config;

import com.antiy.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * WebMVCConfig class
 *
 * @author liuyu
 * @date 2018/11/17
 */

@Configuration
public class WebMVCConfig extends WebMvcConfigurationSupport {

    @Resource
    private UserInterceptor userInterceptors;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(userInterceptors).addPathPatterns("/api/**").excludePathPatterns("/api/v1/user/login",
            "/api/v1/user/code", ",/favicon.ico", "/gen204");
    }

}
