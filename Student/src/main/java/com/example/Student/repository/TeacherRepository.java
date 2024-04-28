package com.example.Student.repository;

import com.example.Student.model.Student;
import com.example.Student.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {


}
