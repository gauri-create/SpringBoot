package com.example.FilterDemo2.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.FilterDemo2.filter.DummyFilter;

@Configuration 
public class FilterConfig {

    @Bean 
    public FilterRegistrationBean<DummyFilter>getDummyFilterBean(){
        FilterRegistrationBean<DummyFilter>registrationBean = 
        new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}
