package com.example.BeanInitializationDemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component 
@Lazy
public class PaymentService {

    OrderService orderService;
    public PaymentService(OrderService orderService){
        this.orderService = orderService;
        System.out.println("PaymentService object created");
    } 

    public void pay(){
        System.out.println("payment done");
        orderService.getOrderDetails();
    }

        
    
}
