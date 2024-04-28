package com.example.Student.controller;

import com.example.Student.dto.teacher.TeacherRequestDto;
import com.example.Student.dto.teacher.TeacherResponseDto;
import com.example.Student.model.Teacher;
import com.example.Student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/add")
    public ResponseEntity<TeacherResponseDto> addTeacher(@RequestBody TeacherRequestDto teacherRequestDto) {
        try{
            TeacherResponseDto teacherResponseDto = teacherService.addTeacher(teacherRequestDto);
            return new ResponseEntity<>(teacherResponseDto,HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TeacherResponseDto>> getAllTeacher() {
        try {
            List<TeacherResponseDto> teacherResponseDtoList = teacherService.getAllTeacher();
            return new ResponseEntity<>(teacherResponseDtoList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getBy/{id}")
    public ResponseEntity<TeacherResponseDto> getTeacherById(@PathVariable Long id) {
        try {
            TeacherResponseDto teacherResponseDto = teacherService.getTeacherById(id);
            return new ResponseEntity<>(teacherResponseDto, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeacherById(@PathVariable Long id) {
        try {
            String status = teacherService.deleteTeacherById(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherResponseDto> updateTeacherById(@RequestBody TeacherRequestDto teacherRequestDto,@PathVariable("id") Long _id) {
        try {
            TeacherResponseDto teacherResponseDto = teacherService.updateTeacherById(teacherRequestDto, _id);
            return new ResponseEntity<>(teacherResponseDto, HttpStatus.OK);
        }catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateBy/{id}")
    public ResponseEntity<TeacherResponseDto> updateTeacherDetailsById(@RequestBody TeacherRequestDto teacherRequestDto, @PathVariable("id") Long _id){
        try {
            TeacherResponseDto teacherResponseDto = teacherService.updateTeacherDetailsById(teacherRequestDto,_id);
            return new ResponseEntity<>(teacherResponseDto,HttpStatus.OK);
        } catch (Exception e){
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
