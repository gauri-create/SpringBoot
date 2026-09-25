package com.example.SpringCoreDemo42;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component 
@ConfigurationProperties ("payment-property")
public class PaymentProperties {

    private String type;
    private int retrycnt;
    private boolean isEnabled;
    private int timeout;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public int getRetrycnt() {
        return retrycnt;
    }
    public void setRetrycnt(int retrycnt) {
        this.retrycnt = retrycnt;
    }

    public boolean isEnabled() {
        return isEnabled;
    }
    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
    
    public int getTimeout() {
        return timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    
}
