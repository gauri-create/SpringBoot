package com.example.AopPointcutAndProxies.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AopPointcutAndProxies.dto.Student;
import com.example.AopPointcutAndProxies.service.StudentService;
import com.example.AopPointcutAndProxies.service.StudentServiceInterface;


@RestController
@RequestMapping("/api/students")
public class StudentController {
    
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping 
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student result =  studentService.createStudent(student);
        return ResponseEntity.ok(result);
    }

    @GetMapping 
    public ResponseEntity<String> getStudent(){
        String s = "All student data";
        return ResponseEntity.ok(studentService.getStudent(s));
    }

}
