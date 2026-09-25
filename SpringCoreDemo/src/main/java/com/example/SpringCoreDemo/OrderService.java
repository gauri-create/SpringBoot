package com.example.SpringCoreDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.SpringCoreDemo.payment.PaymentService;

// @Component 
public class OrderService {

    // @Autowired 
    // final private PaymentService paymentService;
    private PaymentService paymentService;

    @Autowired 
    public OrderService( PaymentService paymentService){
        this.paymentService=paymentService;
    }


    // @Autowired
    // public void setPaymentService(PaymentService paymentService){
    //     this.paymentService=paymentService;
    // }
    
    public void placeOrder(){

        paymentService.pay();
        System.out.println("order placed");

    }
}
