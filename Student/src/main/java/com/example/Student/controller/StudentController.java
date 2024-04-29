package com.example.Student.controller;

import com.example.Student.dto.student.StudentRequestDto;
import com.example.Student.dto.student.StudentResponseDto;
import com.example.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto studentRequestDto){

        try {
            StudentResponseDto studentResponseDto = studentService.addStudent(studentRequestDto);
            return new ResponseEntity<>(studentResponseDto, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDto>> getAllStudent(){
        try {
            List<StudentResponseDto> studentResponseDto = studentService.getAllStudent();
            return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable Long id){

        try{
           StudentResponseDto studentResponseDto = studentService.getStudentById(id);
           return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id){

        try{
              String status = studentService.deleteStudentById(id);
            return new ResponseEntity<>(status,HttpStatus.OK);
        }catch (Exception e){
            return new  ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<StudentResponseDto> updateStudentById(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("id") Long studentId){

        try{
            StudentResponseDto studentResponseDto = studentService.updateStudentById(studentRequestDto,studentId);
            return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/getByName/{first_name}")
    public ResponseEntity<List<StudentResponseDto>> getStudentByFirstName(@PathVariable("first_name") String first_name){

        try{
             List<StudentResponseDto> studentResponseDtosList = studentService.getStudentByFirstName(first_name);
             return new ResponseEntity<>(studentResponseDtosList,HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/getTeacherByStudent/{id}")
    public ResponseEntity<StudentResponseDto> getTeacherByStudentId(@PathVariable("id") Long studentId){

        try{
            StudentResponseDto studentResponseDto = studentService.getTeacherByStudentId(studentId);
            return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
