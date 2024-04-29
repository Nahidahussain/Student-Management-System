package com.example.Student.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name="student")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstName;
    String last_name;
    String roll_no;
    int class_name;

    //mappedBy will not create the extra column, cascade  will transfer all the crud operation to its parent,
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    Teacher teacher;
}
