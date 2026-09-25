package com.example.BeanLifeCycleDemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component 
@Scope ("prototype")
public class CartService /*implements InitializingBean , DisposableBean implements BeanNameAware, ApplicationContextAware*/{

    Map<Integer, String>mp;

    public CartService(){
        mp = new HashMap<>();
        System.out.println("CartService constructor called");
    }

    @PostConstruct 
    public void start2(){
        System.out.println("bean is ready");
		mp.put(1, "gauri");
        mp.put(2, "Rohit");
	}

    @PreDestroy 
    public void stop(){
        mp.clear();
        System.out.println("Bean is getting destroyed");
		
	}

    // @Override
    // public void setBeanName(String name) {
    //     System.out.println("bean name is " + name);
    // }

    // @Override 
    // public void setApplicationContext(ApplicationContext applicationContext){
    //     System.out.println("ApplicationContext name is "+ applicationContext);
        
    // }

    // public void start(){
    //     System.out.println("bean is ready");
	// 	mp.put(1, "gauri");
    //     mp.put(2, "Rohit");
	// }

    // public void stop(){
    //     mp.clear();
    //     System.out.println("Bean is getting destroyed");
    // }

    public void addCart(){
        System.out.println("Added to cart");
    }

    public String getValue(int key){
        return mp.get(key);
    }

    // @Override 
    // public void destroy() throws Exception{
    //     mp.clear();
    //     System.out.println("Bean is getting destroyed");
    // }

     // @Override
    // public void afterPropertiesSet() throws Exception {
    //     System.out.println("Initialization callback");
    //     System.out.println("bean is ready");

    //     // TODO Auto-generated method stub
    //     mp.put(1, "gauri");
    //     mp.put(2, "Rohit");
    //     // throw new UnsupportedOperationException("Unimplemented method 'afterPropertiesSet'");
    // }


}
