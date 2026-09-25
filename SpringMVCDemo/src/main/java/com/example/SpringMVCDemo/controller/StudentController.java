package com.example.SpringMVCDemo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringMVCDemo.service.*;
import com.example.SpringMVCDemo.entity.*;


@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping 
    public ResponseEntity<Student> createStudent(
            @RequestParam Long id, 
            @RequestParam String name, 
            @RequestParam String email) {
        
        Student studentReq = new Student();
        studentReq.setId(id);
        studentReq.setName(name);
        studentReq.setEmail(email);

        Student studentResp = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentResp = studentService.getAllStudent();
        return ResponseEntity.ok(studentResp);
    }
}