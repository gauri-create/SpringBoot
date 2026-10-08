package com.example.hibernateInternalsDemo.service;

import org.springframework.stereotype.Service;

import com.example.hibernateInternalsDemo.model.Student;
import com.example.hibernateInternalsDemo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service 
public class StudentService {

    
    
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional 
    public void createStudent(Student student) {
       studentRepository.save(student);
    }

    @Transactional 
    public Student getStudent(Long id) {
       Student student = studentRepository.findById(id);
       return student;
    }

    @Transactional 
    public void deleteStudent(Long id)  {
        Student student1 = studentRepository.findById(id);

        if(student1 == null){
            throw new RuntimeException("Student not found");
        }
        
       studentRepository.remove(student1);
    }

    @Transactional 
    public void updateStudent(Student student, Long id) {
        Student student1 = studentRepository.findById(id);

        if(student1 == null){
            throw new RuntimeException("Student not found");
        }

        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
    }
}
