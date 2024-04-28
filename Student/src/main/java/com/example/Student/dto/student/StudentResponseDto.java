package com.example.Student.dto.student;

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
}
