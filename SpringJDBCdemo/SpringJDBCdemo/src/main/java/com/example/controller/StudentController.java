package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;

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
        return ResponseEntity.ok("DONE");
    }

    @PutMapping
    public ResponseEntity<String> updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return ResponseEntity.ok("Done");   
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> delResponseEntity(@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("done");
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student resultStudent = studentService.getStudentById(id);
        return ResponseEntity.ok(resultStudent);
    } 

    @GetMapping 
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }
}
