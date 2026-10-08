package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.model.Student;

public class StudentRepository {

    String url = "jdbc:mysql://localhost:3306/student_db";
    String username = "root";
    String password = "Gauri@123";

    public void createUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "Insert INTO student_db (name, email, age) " +
                    "VALUES ('Gauri', 'gauri@gmail.com', 43)";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Create operation successful");
            } else {
                System.out.println("Creation failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }
    }

    public void updateUser() {

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "UPDATE student_db SET age=21 " +
                    "WHERE id = 1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
                System.out.println("Updation operation successful");
            } else {
                System.out.println("Updation failed");
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database connection failure");
            e.printStackTrace();
        }

    }

    public void deleteUser() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "DELETE from student_db WHERE id=1";

            int result = statement.executeUpdate(sql);

            if (result == 1) {
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

    public void getUserById() {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String sql = "SELECT id, name, email, age "+
                        "FROM student_db WHERE id = 2";

            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();

            Student student = mapRow(resultSet);

            System.out.println(student);


            connection.close();
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

}
