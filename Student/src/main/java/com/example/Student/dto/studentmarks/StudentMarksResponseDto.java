package com.example.Student.dto.studentmarks;

import com.example.Student.model.Student;
import com.example.Student.model.Teacher;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentMarksResponseDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

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
