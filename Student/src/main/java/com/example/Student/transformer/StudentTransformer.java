package com.example.Student.transformer;

import com.example.Student.dto.student.StudentRequestDto;
import com.example.Student.dto.student.StudentResponseDto;
import com.example.Student.model.Student;

public class StudentTransformer {

    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto){
        return Student.builder()
                .firstName(studentRequestDto.getFirst_name())
                .last_name(studentRequestDto.getLast_name())
                .class_name(studentRequestDto.getClass_name())
                .roll_no(studentRequestDto.getRoll_no())
                .build();
    }

    public static StudentResponseDto studentToStudentResponseDto(Student student){

        return StudentResponseDto.builder()
                .id(student.getId())
                .class_name(student.getClass_name())
                .first_name(student.getFirstName())
                .last_name(student.getLast_name())
                .roll_no(student.getRoll_no())
                .build();
    }
}
