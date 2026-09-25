package com.example.BeanLifeCycleDemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// @Component("UserBean")
public class UserService implements BeanNameAware, ApplicationContextAware {


    public UserService() {
        System.out.println("UserService constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is " + name);
    }

    public String getBean() {
        return "userBean";
    }

    @Override 
    public void setApplicationContext(ApplicationContext applicationContext){
        System.out.println("ApplicationContext name is "+ applicationContext);
        
    }
}

// callback method
