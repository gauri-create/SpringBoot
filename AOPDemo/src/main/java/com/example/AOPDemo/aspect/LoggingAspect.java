package com.example.AOPDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.AOPDemo.dto.Student;

@Component 
@Aspect 
public class LoggingAspect {

    // @Before("execution(String  com.example.AOPDemo.service.StudentService.createStudent())")
    // public void logBeforeMethod(){

    //     System.out.println("Student is going to be saved");

    //     boolean allowed = false;

    //     if(allowed){
    //         throw new RuntimeException("Method Execution not allowed");
    //     }
    // }

    //  @AfterReturning  (
    //     value = "execution("+
    //     "* com.example.AOPDemo.service.StudentService"+
    //     ".createStudent(..))",
    // returning="result")
    // public void logAfterReturningMethod(Student result){

    //     result.setName("ganesh");
    //     result.setAge(5);

    //     System.out.println("Intercepted createStudent()");
    // }

    // @AfterThrowing  (
    //     value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))",
    //     throwing = "exception")
    // public void logAfterReturningMethod(NullPointerException exception){

    //     System.out.println("Exception type: " + exception.getClass().getName());
    //     System.out.println("Exception Message: " + exception.getMessage());

    // }

    // @After (value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))")
    // public void logAfterMethod(){
    //     System.out.println("logAfterMethod executed");
    // } 

    // @Around (value = "execution(* com.example.AOPDemo.service.StudentService.createStudent(..))")
    // public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
    //     System.out.println("Starting :"+joinPoint.getSignature().getName());

    //     try{
    //         Object result = joinPoint.proceed();
    //         System.out.println("Execution successful");
    //         return result;
    //     }
    //     catch(Exception e){
    //         System.out.println("Execution Failed: "+e.getMessage());
    //         // throw e;
    //         return null;
    //     }
    //     finally{
    //         System.out.println("Execution Completed");
    //     }
    // }

    @Around (value = "execution(* com.example.AOPDemo.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        
        // Object[]  arr = joinPoint.getArgs();

        // String originalString = (String) arr[0];

        // String modifiedString = originalString.toUpperCase();

        // Object[] modifiedArr = {
        //     modifiedString
        // };

        // String returnType = (String)joinPoint.proceed(modifiedArr);

        // returnType = returnType+" : String Intercepted";

        // return returnType;

        Object return1= joinPoint.proceed();

        System.out.println("Intercepted request calling again");
        Object return2 = joinPoint.proceed();
        return return2;
    }
       
}
