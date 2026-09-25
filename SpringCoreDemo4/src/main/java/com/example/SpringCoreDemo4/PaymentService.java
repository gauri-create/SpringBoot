package com.example.SpringCoreDemo4;

import org.springframework.stereotype.Component;

@Component 
public class PaymentService {
    
    public void pay(){
        System.out.println("payment done");
    }
}
