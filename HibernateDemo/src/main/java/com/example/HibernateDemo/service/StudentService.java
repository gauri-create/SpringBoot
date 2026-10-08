package com.example.HibernateDemo.service;

import org.springframework.stereotype.Service;

import com.example.HibernateDemo.model.Student;

import com.example.HibernateDemo.repository.StudentRepository;

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
    public Student getStudentById(long id) {
        Student student = studentRepository.findById(id);
        return student;
    }

    @Transactional
    public void updateStudent(Student student, long id) {
        Student student1 = studentRepository.findById(id);
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setAge(student.getAge());
        
    }

    @Transactional 
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id);

        if(student == null){
            throw new RuntimeException("Student not found");
        }

        studentRepository.remove(student);
    }

}
