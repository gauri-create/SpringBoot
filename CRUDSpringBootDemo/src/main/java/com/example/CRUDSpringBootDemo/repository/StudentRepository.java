package com.example.CRUDSpringBootDemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CRUDSpringBootDemo.entity.Student;

//@Rpository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedIsFalse(Long id);

    List<Student> findByDeletedIsFalse();

    Boolean existsByEmail(String email);


}

    

