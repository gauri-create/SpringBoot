package com.example.SpringScopeDemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component 
@Scope("singleton")
public class OrderService {

    public OrderService(){
        System.out.println("Order service created");
    }

    void placeOrder(){
        System.out.println("Place order");
    }


}
