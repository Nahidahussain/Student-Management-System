package com.example.Student.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teacher")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String teacherId;
    String className;
    int classTeaches;

    @OneToOne
    @JoinColumn(name="stdId") //for custmisation name of the id
    Student student;

}
