package com.example.Student.service;


import com.example.Student.dto.student.StudentRequestDto;
import com.example.Student.dto.student.StudentResponseDto;

import java.util.List;

public interface StudentService {

    StudentResponseDto addStudent(StudentRequestDto studentRequestDto);

    List<StudentResponseDto> getAllStudent();

    StudentResponseDto getStudentById(Long id);

    String deleteStudentById(Long id);

    StudentResponseDto updateStudentById(StudentRequestDto studentRequestDto,Long id);

    List<StudentResponseDto> getStudentByFirstName(String firstName);

    StudentResponseDto getTeacherByStudentId(Long studentId);
}
