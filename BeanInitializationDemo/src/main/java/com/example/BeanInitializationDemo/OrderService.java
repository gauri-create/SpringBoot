package com.example.BeanInitializationDemo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component 
// @Lazy 
public class OrderService {

    PaymentService paymentService;
    public OrderService(@Lazy PaymentService paymentService){
        this.paymentService=paymentService;
        System.out.println("OrderService object is created");
    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Place order");
    }

    public void getOrderDetails() {
        System.out.println("get order details");
    }

}
