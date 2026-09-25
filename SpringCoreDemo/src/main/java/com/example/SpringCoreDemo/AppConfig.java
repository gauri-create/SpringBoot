package com.example.SpringCoreDemo;

import java.lang.reflect.Parameter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// import com.example.SpringCoreDemo.payment.PaymentService;
import com.example.SpringCoreDemo.payment.*;
import com.example.SpringCoreDemo2.CartService;

@Configuration 
@ComponentScan({"com.example.SpringCoreDemo", "com.example.SpringCoreDemo2"})
public class AppConfig {
    
    @Bean
    public User createUser(){
        return new User("Gauri", 20);
    }

    @Bean 
    public CartService createCartService(){
        return new CartService();
    }

    @Bean 
    // @Primary 
    @Qualifier ("card")
    public PaymentService createCardPaymentService(){
        return new CardPayment();
    }

    @Bean 
    // @Primary 
    @Qualifier ("upi")
    public PaymentService createUpiPaymentService(){
        return new UpiPayment();
    }

    @Bean 
    public OrderService createOrderService(@Qualifier("card")PaymentService paymentService){
        return new OrderService( paymentService);
    }
    // @Bean 
    // public OrderService createOrderService(PaymentService paymentService){
    //     // PaymentService payment = createCarPaymentService();
    //     // OrderService order = new OrderService();
    //     // order.setPaymentService(payment);
    //     // return order;
    //     return new OrderService();
    // }


}
