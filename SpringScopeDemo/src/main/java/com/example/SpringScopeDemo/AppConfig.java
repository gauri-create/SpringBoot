package com.example.SpringScopeDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig
 */

@Configuration 
@ComponentScan 
public class AppConfig {

    @Bean 
    public OrderService getOrder1(){
        return new OrderService();
    }

    @Bean 
    public OrderService getOrder2(){
        return new OrderService();
    }
}
