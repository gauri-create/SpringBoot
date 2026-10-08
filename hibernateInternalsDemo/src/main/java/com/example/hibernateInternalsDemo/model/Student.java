package com.example.hibernateInternalsDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Student {
    
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private long age;
    
    public Student() {
    }

    public Student(Long id, String name, String email, long age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
}
