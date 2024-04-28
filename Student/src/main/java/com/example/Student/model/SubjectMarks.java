package com.example.Student.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject_marks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubjectMarks {

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
