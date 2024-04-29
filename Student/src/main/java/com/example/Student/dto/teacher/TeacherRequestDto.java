package com.example.Student.dto.teacher;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeacherRequestDto {

    String name;
    String teacherId;
    String className;
    int classTeaches;
    Long studentId;
}
