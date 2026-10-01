package com.example.AopIntroductionDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.AopIntroductionDemo.dto.Student;

@Component 
// @Primary 
public class LoggingDecorator implements StudentService {

    private StudentServiceImpl studentServiceImpl;

    // @Autowired 
    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }


    @Override
    public void createStudent(Student student) {
        
        LoggingServiceUtil.logStart("StudentServicrImpl", 
                    "createStudent");

        studentServiceImpl.createStudent(student);

        LoggingServiceUtil.logEnd("StudentServiceImpl", "createStudent");
    }
    
}
