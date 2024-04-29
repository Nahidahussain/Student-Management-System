package com.example.Student.dto.student;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentRequestDto {
    String first_name;
    String last_name;
    String roll_no;
    int class_name;

    Long teacherId;
}
