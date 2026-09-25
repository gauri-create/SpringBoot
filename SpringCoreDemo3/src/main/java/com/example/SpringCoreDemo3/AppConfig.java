package com.example.SpringCoreDemo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * AppConfig
 */

@ComponentScan 
@Configuration 
public class AppConfig {

    @Bean 
    public UserService getUserService(){
        return new UserService();
    }
}
