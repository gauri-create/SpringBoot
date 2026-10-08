package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Student;

public class StudentRepository2 {
    
    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Gauri@123";
    
    public void createStudent(Student student) {
        
        String sql ="""
                    INSERT INTO student_db(name, email, age)
                    VALUES(?, ?, ?)
                    """;

        try(Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {
            
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getAge());

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 1){
                System.out.println("Create Student successful");
            }
            else{
                System.out.println("Create Student failed");
            }

            
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }

    
    }

    public void updateStudent(Student student, Long id) {

        String sql = """
                            UPDATE student_db 
                            SET name=?,
                                email=?,
                                age=?
                            WHERE id = ?""";

        try(
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ) {
            
                preparedStatement.setString(1, student.getName());
                preparedStatement.setString(2, student.getEmail());
                preparedStatement.setInt(3, student.getAge());
                preparedStatement.setLong(4, id);
            
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                System.out.println("Updation operation successful");
            } else {
                System.out.println("Updation failed");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }

    }

    public void deleteStudent(Long id) {
        String sql = "DELETE from student_db WHERE id=?";
        try (
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            
            preparedStatement.setLong(1, id);

            int rowAffected = preparedStatement.executeUpdate();

            if (rowAffected == 1) {
                System.out.println("Delete operation successful");
            } else {
                System.out.println("Deletion failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }
    }

    public void getStudentById(Long id) {

        String sql = "SELECT id, name, email, age FROM student_db WHERE id=?";

        try (
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            
            preparedStatement.setLong(1, id);

            try(
                ResultSet resultSet = preparedStatement.executeQuery()
            ){
                if(resultSet.next()){
                    Student student = mapRow(resultSet);
                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }
    }

    public void getAllStudent() {

        String sql = """
                        SELECT id, name, email, age FROM student_db 
                    """;

        try (
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ){
            
            try(
                ResultSet resultSet = preparedStatement.executeQuery()
            ){
                List<Student>studentList = new ArrayList<>();

                while(resultSet.next()){
                    Student student = mapRow(resultSet);
                    studentList.add(student);
                    System.out.println(student);
                }
            }

        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }
    }

	private Student mapRow(ResultSet resultSet) throws SQLException {
		Student student= new Student();

        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString ("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));

		return student;
	}

    public void completeCRUD(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age "+
                        "FROM student_db WHERE id = 2";

            boolean result = statement.execute(sql);
           
            if(result){
                ResultSet resultSet = statement.getResultSet();
                Student student = mapRow(resultSet);
                System.out.println(student);
            }
            else{
                int rowAffected = statement.getUpdateCount();
                System.out.println(rowAffected);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }
    }

}
