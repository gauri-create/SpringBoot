package com.example.AopPointcutAndProxies.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.AopPointcutAndProxies.annotation.TrackExecutionTime;
@Component
@Aspect 
public class SimpleAspect {
    
    // @Before("@annotation()")
    // public void longBeforeMethod(){
    //     System.out.println("Method Intercepted");
    // }


    @Around("@annotation(trackExecutionTime)")
    public Object measureExecution(ProceedingJoinPoint joinPoint,
        TrackExecutionTime trackExecutionTime) throws Throwable{
        long startTime = System.currentTimeMillis();

        try{
            Thread.sleep(2000);
            Object result = joinPoint.proceed();
            return result;
        }

        finally{
            String methodName = joinPoint.getSignature().getName();
            long endTime = System.currentTimeMillis();
            long duration = endTime-startTime;

            String operation = trackExecutionTime.operation();
            if(operation.isBlank()){
                operation=joinPoint.getSignature().getName();
            } 

            long warningThreshold = trackExecutionTime.warnAfter();

            if(duration>=warningThreshold){
                System.out.println("SLOW OPERATION ALERT : "+
                    "Time Taken by "+
                    operation + " : "+duration);
            }

            System.out.println("Time taken by "+operation+ " is "+ duration);
        }
    }

}
