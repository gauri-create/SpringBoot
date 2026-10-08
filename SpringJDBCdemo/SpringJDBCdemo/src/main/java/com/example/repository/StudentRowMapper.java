package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.model.Student;

public class StudentRowMapper implements RowMapper<Student>{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
   
        Student student = new Student();

        student.setId(rs.getLong("id"));
        student.setName(rs.getString("name"));
        student.setEmail(rs.getString("email"));
        student.setAge(rs.getInt("age"));

        return student;
    }

}
