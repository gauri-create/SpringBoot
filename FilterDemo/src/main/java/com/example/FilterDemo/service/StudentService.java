package com.example.FilterDemo.service;

import org.springframework.stereotype.Service;

import com.example.FilterDemo.dto.Student;

@Service
public class StudentService {

    public void createStudent(Student student) {
        System.out.println("Student Created");
        System.out.println(student.getName());
        System.out.println(student.getEmail());

        // try {
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        // }
    }
}
