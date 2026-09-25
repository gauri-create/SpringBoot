package com.example.CRUDSpringBootDemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.CRUDSpringBootDemo.entity.Student;
import com.example.CRUDSpringBootDemo.exception.DuplicateResourceException;
import com.example.CRUDSpringBootDemo.exception.ResourceNotFoundException;
import com.example.CRUDSpringBootDemo.repository.StudentRepository;
import com.example.CRUDSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.CRUDSpringBootDemo.dto.CreateStudentResponseDTO;
import com.example.CRUDSpringBootDemo.dto.UpdateStudentRequestDTO;
import com.example.CRUDSpringBootDemo.dto.UpdateStudentResponseDTO;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDTO createStudent(CreateStudentRequestDTO studentReqDTO) {
        Student student = mapToCreateEntity(studentReqDTO);

        if(emailExist(student)){
            throw new DuplicateResourceException("Student with email " +  student.getEmail()+ " already exists");
        }
        Student studentResp = studentRepository.save(student);

        return mapToCreateDTO(studentResp);

    }

   

    private Student mapToCreateEntity(CreateStudentRequestDTO studentReqDTO) {
        Student student = new Student();

        student.setName(studentReqDTO.getName());
        student.setAge(studentReqDTO.getAge());
        student.setEmail(studentReqDTO.getEmail());
        student.setRollno(studentReqDTO.getRollNo());
        student.setSubject(studentReqDTO.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;
    }

    private CreateStudentResponseDTO mapToCreateDTO(Student student) {
        CreateStudentResponseDTO responseDTO = new CreateStudentResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollno(student.getRollno());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setMessage("Student Saved Successfully!!!");
        responseDTO.setCreatedAt(student.getCreatedAt());
        responseDTO.setUpdatedAt(student.getUpdatedAt());

        return responseDTO;

    }

    public CreateStudentResponseDTO getStudent(Long id) {
        Student studentResp = studentRepository
                .findById(id)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Student with id "+ id + " not found"));

        return mapToCreateDTO(studentResp);

    }

    public List<CreateStudentResponseDTO> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();

        return studentList.stream()
                .map(this::mapToCreateDTO)
                .toList();
    }

    public UpdateStudentResponseDTO updateStudent(Long id, UpdateStudentRequestDTO student) {
        
        Student existingStudent = studentRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));
       
        existingStudent.setName(student.getName());
        existingStudent.setRollno(student.getRollno());
        existingStudent.setAge(student.getAge());
        existingStudent.setSubject(student.getSubject());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        Student savedstudent = studentRepository.save(existingStudent);

        return mapToUpdateDTO(savedstudent);
    }

    public UpdateStudentResponseDTO mapToUpdateDTO(Student student) {

        UpdateStudentResponseDTO responseDTO = new UpdateStudentResponseDTO();

        responseDTO.setId(student.getId());
        responseDTO.setName(student.getName());
        responseDTO.setAge(student.getAge());
        responseDTO.setEmail(student.getEmail());
        responseDTO.setRollno(student.getRollno());
        responseDTO.setSubject(student.getSubject());
        responseDTO.setMessage("Student Updated Successfully!!!");
        responseDTO.setUpdatedAt(student.getUpdatedAt());

        return responseDTO;

    }

    public void deleteStudent(Long id) {
        Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));
       
        studentRepository.delete(studentToBeDeleted);
    }

    public void deleteStudentSoftly(Long id) {
       Student studentToBeDeleted = studentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id "+ id + " not found"));
       

       
        studentToBeDeleted.setDeleted(true);
        studentRepository.save(studentToBeDeleted);
    }

     private boolean emailExist(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }

}
