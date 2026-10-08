package com.example.hibernateInternalsDemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hibernateInternalsDemo.model.Student;
import com.example.hibernateInternalsDemo.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping 
    public ResponseEntity<String> createStudent(@RequestBody Student student){
        studentService.createStudent(student);
        return ResponseEntity.ok("Done");
    }

    @GetMapping ("/{id}") 
    public ResponseEntity<Student> getStudent( @PathVariable Long id){
        Student student = studentService.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @PutMapping ("/{id}") 
    public ResponseEntity<String> updateStudent( @RequestBody Student student,@PathVariable Long id ) throws Exception{
        studentService.updateStudent(student, id);
        return ResponseEntity.ok("Done");
    }

    @ DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Done");
    }
    
    
}
