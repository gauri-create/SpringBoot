package com.example.AopIntroductionDemo.service;

import org.springframework.stereotype.Service;

import com.example.AopIntroductionDemo.dto.Student;
import com.example.AopIntroductionDemo.repository.StudentRepository;

@Service 
public class StudentServiceImpl implements StudentService{
    
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(Student student){
 
        studentRepository.save(student);
   
     }
}
