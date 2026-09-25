package com.example.XMLBasedConfigDemo.payment;

public class CardPayment implements PaymentServiceInterface {

    @Override
    public void pay() {
        System.out.println("Payment processed successfully using Credit/Debit Card!");
    }
    
}