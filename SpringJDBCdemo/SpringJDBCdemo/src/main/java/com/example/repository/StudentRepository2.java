package com.example.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public class StudentRepository2 {

    private JdbcTemplate jdbcTemplate;

    public StudentRepository2(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // StudentRowMapper studentRowMapper = new StudentRowMapper();

    private RowMapper<Student> rowMapper = new BeanPropertyRowMapper<>(Student.class);

    public void createStudent(Student student) {

        String sql = """
                INSERT INTO students(name, email, age)
                VALUES(?, ?, ?)
                """;

        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge());

        if (rowAffected == 1) {
            System.out.println("Create Student successful");
        } else {
            System.out.println("Create Student failed");
        }

    }

    public void updateStudent(Student student, Long id) {

        String sql = """
                UPDATE students
                SET name=?,
                    email=?,
                    age=?
                WHERE id = ?""";
        int rowAffected = jdbcTemplate.update(sql,
                student.getName(), student.getEmail(), student.getAge(), id);
        if (rowAffected == 1) {
            System.out.println("Updation operation successful");
        } else {
            System.out.println("Updation failed");
        }

    }

    public void deleteStudent(Long id) {
        String sql = "DELETE from students WHERE id=?";
        int rowAffected = jdbcTemplate.update(sql, id);

        if (rowAffected == 1) {
            System.out.println("Delete operation successful");
        } else {
            System.out.println("Deletion failed");
        }
    }

    public Student getStudentById(Long id) {

    String sql = "SELECT id, name, email, age FROM students WHERE id=?";

    return jdbcTemplate.queryForObject(sql,
        // studentRowMapper,
        rowMapper,
        id);
    }

    public List<Student> getAllStudent() {

    String sql = """
    SELECT id, name, email, age FROM students
    """;

    List<Student> students = jdbcTemplate.query(sql, 
        // studentRowMapper
        rowMapper);
    return students;
    }

}
