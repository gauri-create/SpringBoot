package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository2;

@Service 
public class StudentService {

    private StudentRepository2 studentRepository2;
    public StudentService(StudentRepository2 studentRepository2) {
        this.studentRepository2 = studentRepository2;
    }
    
    public void createStudent(Student student) {
        studentRepository2.createStudent(student);
    }

    public void updateStudent(Student student) {
       studentRepository2.updateStudent(student, student.getId());
    }

    public void deleteStudent(long id) {
        studentRepository2.deleteStudent(id);
    }

    public Student getStudentById(long id) {
        Student student = studentRepository2.getStudentById(id);
        return student;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository2.getAllStudent();
        return studentList;
    }
    
}
