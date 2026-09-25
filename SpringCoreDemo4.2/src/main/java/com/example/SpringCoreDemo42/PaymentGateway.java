package com.example.SpringCoreDemo42;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    // @Value("${payment-gateway.type:phonepay}")
    // private String type;

    // @Value("${payment-gateway.retrycnt}")
    // private int retrycnt;

    // public PaymentGateway( String type,
    //          int retrycnt) {
    //     this.type = type;
    //     this.retrycnt = retrycnt;
    // }

    // public String getType() {
    //     return type;
    // }

    // public void setType(String type) {
    //     this.type = type;
    // }

    // public int getRetryCnt() {
    //     return retrycnt;
    // }

    // public void setRetryCnt(int retrycnt) {
    //     this.retrycnt = retrycnt;
    // }

    private PaymentProperties paymentProperties;

    public PaymentProperties getPaymentProperties() {
        return paymentProperties;
    }

    public PaymentGateway(PaymentProperties paymentProperties){
        this.paymentProperties=paymentProperties;
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCnt() {
        return paymentProperties.getRetrycnt();
    }

    public boolean isEnabled() {
       return paymentProperties.isEnabled();
    }

    public int timeout() {
        return paymentProperties.getTimeout();
    }

    public void print() {
        System.out.println(getType());
        System.out.println(getRetryCnt());
        System.out.println(isEnabled());
        System.out.println(timeout());
    }
}
