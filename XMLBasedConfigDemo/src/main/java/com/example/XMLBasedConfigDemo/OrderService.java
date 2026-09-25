package com.example.XMLBasedConfigDemo;

import com.example.XMLBasedConfigDemo.payment.*;;

public class OrderService {

    private PaymentServiceInterface paymentService;
    public OrderService(PaymentServiceInterface paymentService){
        this.paymentService=paymentService;
        System.out.println("orderService object/ bean created");
    }
    
    // public void setpaymentServiceBean(PaymentService paymentService){
    //     this.paymentService=paymentService;
    // }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
