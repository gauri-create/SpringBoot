package com.example;
import com.example.model.Student;
// import com.example.repository.StudentRepository;
import com.example.repository.StudentRepository2;


public class App 
{
    public static void main( String[] args )
    {


        // StudentRepository studentRepository = new StudentRepository();
        // studentRepository.createUser();
        // studentRepository.updateUser();
        // studentRepository.deleteUser();
        // studentRepository.getUserById();

        // Student student = new Student();
        // student.setName("kavya");
        // student.setEmail("kavya@gmail.com");
        // student.setAge(32);


        StudentRepository2 studentRepository2 = new StudentRepository2();
        // studentRepository2.createStudent(new Student("ika", "ika@gmail.com", 40));
        // studentRepository2.updateStudent(new Student("mika", "mika@gmail.com", 4),9L);
        // studentRepository2.deleteStudent(8L);
        // studentRepository2.getStudentById(5L);
        studentRepository2.getAllStudent();
    }
}


