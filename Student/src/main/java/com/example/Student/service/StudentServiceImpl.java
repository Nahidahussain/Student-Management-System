package com.example.Student.service;

import com.example.Student.dto.student.StudentRequestDto;
import com.example.Student.dto.student.StudentResponseDto;
import com.example.Student.model.Student;
import com.example.Student.repository.StudentRepository;
import com.example.Student.transformer.StudentTransformer;
import com.example.Student.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;


    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto){

        //convert request dto to studentObject
        Student student = StudentTransformer.studentRequestDtoToStudent(studentRequestDto);
        Student savedStudent = studentRepository.save(student);

        //prepare responsedto from saved object
        return StudentTransformer.studentToStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> getAllStudent(){

        // get all students
        List<Student> studentList =  studentRepository.findAll();

        //prepare responsedto from student list
//        List<StudentResponseDto> studentResponseDtos = studentList.stream().map(StudentTransformer :: studentToStudentResponseDto).collect(Collectors.toList());
        List<StudentResponseDto> studentResponseDtoList = new ArrayList<>();
        for(Student student :studentList){
            // convert the student to studentResponseDto
            StudentResponseDto studentResponseDto = StudentTransformer.studentToStudentResponseDto(student);
            studentResponseDtoList.add(studentResponseDto);  // add the responseDTo to list
        }

        return studentResponseDtoList;
    }

    public StudentResponseDto getStudentById(Long id){

        Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student not found !!"));
         return StudentTransformer.studentToStudentResponseDto(student);
    }

    public String deleteStudentById(Long id){
        try {
            Student student = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("Student Not Found"));
            studentRepository.deleteById(student.getId());
            return Messages.DELETED_SUCCESSFULLY;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }


    }

    public StudentResponseDto updateStudentById(StudentRequestDto studentRequestDto,Long studentId){
        // get the student
        Student student = studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student with this id not found"));
        // set the fields
        student.setFirstName(studentRequestDto.getFirst_name());
        student.setLast_name(studentRequestDto.getLast_name());
        student.setClass_name(studentRequestDto.getClass_name());
        student.setRoll_no(studentRequestDto.getRoll_no());

        // save
        Student updatedStudent = studentRepository.save(student);

        // prepare the response
        return StudentTransformer.studentToStudentResponseDto(updatedStudent);
    }
    public List<StudentResponseDto> getStudentByFirstName(String firstName){

        try {
            List<Student> studentList = studentRepository.findAllByFirstName(firstName);
//            return StudentTransformer.studentToStudentResponseDto(studentList,HttpStatus.OK);
            List<StudentResponseDto> studentResponseDtos = studentList.stream().map(StudentTransformer :: studentToStudentResponseDto).collect(Collectors.toList());
            return studentResponseDtos;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
