package com.example.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @ Program       :
 * @ Description   :  web拦截器配置类
 * @ Author        :  lj
 * @ CreateDate    :  2020-1-31 23:23
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    /**
     * 解决跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(true);
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3)));
        configurer.setDefaultTimeout(30000);
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        excludePath.add("/patient/login");
        excludePath.add("/docker/login");
        excludePath.add("/admin/login");
        excludePath.add("");
        excludePath.add("/");
        excludePath.add("/swagger-resources/**");
        excludePath.add( "/webjars/**");
        excludePath.add("/v2/**");
        excludePath.add("/swagger-ui.html/**");
        excludePath.add("/doc.html/**");
        excludePath.add("/webjars/**");
        excludePath.add("/static/**");  //静态资源
        excludePath.add("/assets/**");  //静态资源
//        excludePath.add("/user/isActivate/**");
//        excludePath.add("/user/activateAccountCode/**");
//        excludePath.add("/user/activateAccount/**");
//        excludePath.add("/user/resetPassword/**");
//        excludePath.add("/user/resetPasswordEmail/**");
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
