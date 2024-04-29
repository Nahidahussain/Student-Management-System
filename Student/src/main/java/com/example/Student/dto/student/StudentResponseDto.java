package com.example.Student.dto.student;

import com.example.Student.dto.teacher.TeacherResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponseDto {
    Long id;
    String first_name;
    String last_name;
    String roll_no;
    int class_name;

    TeacherResponseDto teacherResponseDto;
}
