package com.example.AopPointcutAndProxies.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component 
@Aspect 

public class LoggingAspect {
    
   
    // @Before("@within(org.springframework.stereotype.Service)")
    // public void logbeforeMethod(){
    //     System.out.println("Method intercepted");
    // }

    // @Before("args(com.example.AopPointcutAndProxies.dto.Student)"+
    //         "&&"+
    //         "within(com.example.AopPointcutAndProxies.service..*)")
    // public void logbeforeMethod2(){
    //     System.out.println("Method intercepted  fgdf");
    // }

    // @Before("@args(org.springframework.stereotype.Component)"+
    //         "&&"+
    //         "within(com.example.AopPointcutAndProxies.service..*)")
    // public void logbeforeMethod3(){
    //     System.out.println("Method intercepted  fgdf");
    // }


    // @Before("this(com.example.AopPointcutAndProxies.service.StudentService)")
    // public void logbeforeMethod4(){
    //     System.out.println("Method intercepted  fgdf");
    // }

    // @Around ("@annotation(com.example.AopPointcutAndProxies.annotation.TrackExecution)")
    // public void logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
    //     long startTime = System.currentTimeMillis();

    //     joinPoint.proceed();

    //     long endTime = System.currentTimeMillis();

    //     System.out.println(endTime-startTime);
    // }

    // @Before("execution(com.example.AopPointcutAndProxies.dto.Student"+
    //     "com.example.AopPointcutAndProxies.service.Student.createStudent("+
    //     "com.example.AopPointcutAndProxies.dto.Student))")
    // public void logbeforeMethod2(){
    //     System.out.println("Method intercepted");
    // }
}
