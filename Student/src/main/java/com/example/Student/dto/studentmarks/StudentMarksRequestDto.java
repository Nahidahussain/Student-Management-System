package com.example.Student.dto.studentmarks;

import com.example.Student.model.Student;
import com.example.Student.model.Teacher;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentMarksRequestDto {

    @ManyToOne
    Teacher teacher;

    @ManyToOne
    Student student;

    String science;
    String math;
    String hindi;
    String socialScience;

    int marks;
}
