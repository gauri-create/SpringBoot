package com.example.FilterDemo2.service;

import org.springframework.stereotype.Service;

import com.example.FilterDemo2.dto.Student;
import com.example.FilterDemo2.dto.StudentResponseDto;

@Service 
public class StudentService {

    public StudentResponseDto createStudent(Student student){

        StudentResponseDto responseDto = new StudentResponseDto();

        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getEmail());

        System.out.println("Student Created");
        return responseDto;
    }

}
