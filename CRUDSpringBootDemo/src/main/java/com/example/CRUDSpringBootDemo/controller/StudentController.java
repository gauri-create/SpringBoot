package com.example.CRUDSpringBootDemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CRUDSpringBootDemo.service.StudentService;

import jakarta.validation.Valid;

import com.example.CRUDSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.CRUDSpringBootDemo.dto.CreateStudentResponseDTO;
import com.example.CRUDSpringBootDemo.dto.UpdateStudentRequestDTO;
import com.example.CRUDSpringBootDemo.dto.UpdateStudentResponseDTO;


//validations --> spring-boot-starter-validation

@RestController

@RequestMapping("/api/students")


public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService=studentService;

    }

    // create student
    @PostMapping
    public ResponseEntity<CreateStudentResponseDTO> createStudent(@Valid @RequestBody CreateStudentRequestDTO studentRequestDTO) {
        CreateStudentResponseDTO createStudent = studentService.createStudent(studentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createStudent);
    }

    // read student
    @GetMapping ("/{id}")
    public ResponseEntity<CreateStudentResponseDTO>getStudent(@PathVariable  Long id){
        CreateStudentResponseDTO studentResp = studentService.getStudent(id);
        return ResponseEntity.ok(studentResp);
     }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDTO>> getAllStudent(){
        List<CreateStudentResponseDTO>studentList = studentService.getAllStudent();
        return ResponseEntity.ok(studentList);
    }

    // update student
     @PutMapping 
    public ResponseEntity<UpdateStudentResponseDTO>updateStudent(@RequestParam  Long id, @RequestBody UpdateStudentRequestDTO student){
        UpdateStudentResponseDTO studentResp = studentService.updateStudent(id, student);
        return ResponseEntity.ok(studentResp);
    }

    // delete student
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable  Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    //soft delete
    @PatchMapping ("/delete-soft")
    public ResponseEntity<Void> deleteStudentSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);
        return ResponseEntity.noContent().build();
    }
}
