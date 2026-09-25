package com.example.BeanLifeCycleDemo;

import org.springframework.stereotype.Component;

@Component 
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void placeOrder(){
        System.out.println("order placed");
        paymentService.pay();
    }
}

//Aware Interfaces
