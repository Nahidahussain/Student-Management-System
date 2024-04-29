package com.example.Student.dto.teacher;

import com.example.Student.dto.student.StudentResponseDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherResponseDto {

    Long id;
    String name;
    String teacherId;
    String className;
    int classTeaches;

    StudentResponseDto studentResponseDto;
}
