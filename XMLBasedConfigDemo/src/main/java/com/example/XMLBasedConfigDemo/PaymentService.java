package com.example.XMLBasedConfigDemo;

public class PaymentService {
    
    private String type;
    private  int retrycnt;

    public PaymentService(String type, int retrycnt){
        this.type=type;
        this.retrycnt=retrycnt;
        System.out.println(this.type + this.retrycnt);
    }
        
    public void pay(){
        System.out.println("Payment done");
    }
}
