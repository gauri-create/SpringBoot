package com.example.XMLBasedConfigDemo.payment;

public class UPIPayment implements PaymentServiceInterface {

    @Override
    public void pay() {
        System.out.println("Payment processed successfully using UPI!");
    }
    
}