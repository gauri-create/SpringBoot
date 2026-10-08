package com.example.AopPointcutAndProxies.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component 
@Aspect 
public class ApplicationPointcuts {
    
    @Pointcut ("within(com.example.AopPointcutAndProxies.controller..*)")
    public void controllerLayer(){

    }

    @Pointcut ("within(com.example.AopPointcutAndProxies.service..*)")
    public void serviceLayer(){

    }

    @Pointcut ("execution(public * * (..))")
    public void publicMethod(){

    }

    @Pointcut ("serviceLayer() && publicMethod()")
    public void publicServiceMethod(){

    }

    @Pointcut ("execution(* *.get* (..))")
    public void getterMethod(){
        
    }

}
