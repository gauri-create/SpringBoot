package com.example.AopIntroductionDemo.repository;

import org.springframework.stereotype.Repository;

import com.example.AopIntroductionDemo.dto.Student;

@Repository 
public class StudentRepository {

    public void save(Student student) {
        System.out.println("Student saved");
    }
    
}
