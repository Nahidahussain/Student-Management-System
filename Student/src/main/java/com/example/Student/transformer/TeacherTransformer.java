package com.example.Student.transformer;

import com.example.Student.dto.teacher.TeacherRequestDto;
import com.example.Student.dto.teacher.TeacherResponseDto;
import com.example.Student.model.Teacher;

public class TeacherTransformer {

    public static Teacher teacherRequestDtoToTeacher(TeacherRequestDto teacherRequestDto) {

        return Teacher.builder()
                .name(teacherRequestDto.getName())
                .teacherId(teacherRequestDto.getTeacherId())
                .className(teacherRequestDto.getClassName())
                .classTeaches(teacherRequestDto.getClassTeaches())
                .build();
    }

    public static TeacherResponseDto teacherToTeacherResponseDto(Teacher teacher){

        return TeacherResponseDto.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .teacherId(teacher.getTeacherId())
                .className(teacher.getClassName())
                .classTeaches(teacher.getClassTeaches())
            .build();
    }
}
