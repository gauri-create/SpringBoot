package com.example.SpringMVCDemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * WebConfig
 */

@Configuration
@ComponentScan(basePackages = "com.example.SpringMVCDemo")
@EnableWebMvc
public class WebConfig {

}
