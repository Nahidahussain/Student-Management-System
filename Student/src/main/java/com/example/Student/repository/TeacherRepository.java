package com.example.Student.repository;

import com.example.Student.model.Student;
import com.example.Student.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
//    Optional<Student> findByStudent(Long studentId);
}
