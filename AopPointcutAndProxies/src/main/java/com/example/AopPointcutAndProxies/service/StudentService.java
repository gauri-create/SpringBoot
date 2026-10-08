package com.example.AopPointcutAndProxies.service;


import org.springframework.stereotype.Service;

import com.example.AopPointcutAndProxies.dto.Student;
import com.example.AopPointcutAndProxies.annotation.TrackExecutionTime;
@Service 
public class StudentService {
 
    @TrackExecutionTime(
        warnAfter = 2000,
        operation = "creating new student"
    )
    public  Student createStudent(Student student) {
        System.out.println("Student Saved");
        return student;
    }
    
    @TrackExecutionTime(
        warnAfter = 1500,
        operation = "get Student data"
    )
    public String getStudent(String s){
        System.out.println(s);
        return s;
    }
}
