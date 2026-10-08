package com.example.AopPointcutAndProxies.service;

import com.example.AopPointcutAndProxies.dto.Student;

public interface StudentServiceInterface {
    
    Student createStudent(Student student);

    String getStudent(String s);
}
