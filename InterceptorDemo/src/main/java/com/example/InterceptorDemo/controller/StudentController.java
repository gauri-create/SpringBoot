package com.example.InterceptorDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @PostMapping ("/api/students")
    public ResponseEntity<String>createStudent(){
        System.out.println("Constructor called");
        return ResponseEntity.ok("Student created Successfully!");
    }
}
