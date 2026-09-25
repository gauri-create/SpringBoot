package com.example.CRUDSpringBootDemo.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String message){
        super(message);
    }
}
