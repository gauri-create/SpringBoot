package com.example.SpringCoreDemo42;

import org.springframework.stereotype.Component;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

@Component 
public class AppRunner implements /*ApplicationRunner */ CommandLineRunner{

    private PaymentGateway paymentGateway;

    public AppRunner(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }
    // @Override
    // public void run(ApplicationArguments args) throws Exception {
    //     paymentGateway.print();
    // }

    @Override
    public void run(String... args) throws Exception {
        paymentGateway.print();
    }

}
