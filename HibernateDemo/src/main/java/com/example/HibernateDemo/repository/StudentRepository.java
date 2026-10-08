package com.example.HibernateDemo.repository;

import org.springframework.stereotype.Repository;

import com.example.HibernateDemo.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository 
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Student student) {
        entityManager.persist(student);
    }
   
    public Student findById(long id) {
        return entityManager.find(Student.class, id);
    }

    public void remove(Student student){
        entityManager.remove(student);
    }
    
}
