package com.example.Student.service;

import com.example.Student.dto.teacher.TeacherRequestDto;
import com.example.Student.dto.teacher.TeacherResponseDto;

import java.util.List;

public interface TeacherService {

    TeacherResponseDto addTeacher(TeacherRequestDto teacherRequestDto);

    List<TeacherResponseDto> getAllTeacher();

    TeacherResponseDto getTeacherById(Long id);

    String deleteTeacherById(Long id);

    TeacherResponseDto updateTeacherById(TeacherRequestDto teacherRequestDto,Long id);

    TeacherResponseDto updateTeacherDetailsById(Long id,String name,String teacherId,String className);
}
