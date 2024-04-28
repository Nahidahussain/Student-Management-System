package com.example.Student.service;

import com.example.Student.dto.teacher.TeacherRequestDto;
import com.example.Student.dto.teacher.TeacherResponseDto;
import com.example.Student.model.Teacher;
import com.example.Student.repository.TeacherRepository;
import com.example.Student.transformer.TeacherTransformer;
import com.example.Student.utils.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    TeacherRepository teacherRepository;

    public TeacherResponseDto addTeacher(TeacherRequestDto teacherRequestDto) {

        Teacher teacher = TeacherTransformer.teacherRequestDtoToTeacher(teacherRequestDto);
        Teacher savedTeacher = teacherRepository.save(teacher);
        return TeacherTransformer.teacherToTeacherResponseDto(savedTeacher);
    }

    public List<TeacherResponseDto> getAllTeacher() {

        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherResponseDto> teacherResponseDtos = teacherList.stream().map(TeacherTransformer::teacherToTeacherResponseDto).collect(Collectors.toList());
        return teacherResponseDtos;
    }

    public TeacherResponseDto getTeacherById(Long id) {

        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new RuntimeException("Teacher not Found"));
        return TeacherTransformer.teacherToTeacherResponseDto(teacher);
    }

    public String deleteTeacherById(Long id) {
        try {
            Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher not Found"));
            teacherRepository.deleteById(teacher.getId());
            return Messages.DELETED_SUCCESSFULLY;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    public TeacherResponseDto updateTeacherById(TeacherRequestDto teacherRequestDto, Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new RuntimeException("Teacher not found"));
        teacher.setName(teacherRequestDto.getName());
        teacher.setClassName(teacherRequestDto.getClassName());
        teacher.setClassTeaches(teacherRequestDto.getClassTeaches());
        teacher.setTeacherId(teacherRequestDto.getTeacherId());

        Teacher teacherSaved = teacherRepository.save(teacher);

        return TeacherTransformer.teacherToTeacherResponseDto(teacherSaved);
    }

    public TeacherResponseDto updateTeacherDetailsById(TeacherRequestDto teacherRequestDto, Long id) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()->new RuntimeException("Teacher not found"));
        if(teacherRequestDto.getName() != null){
            teacher.setName(teacherRequestDto.getName());
        }
        if(teacherRequestDto.getClassName() != null) {
            teacher.setClassName(teacherRequestDto.getClassName());
        }
        if(teacherRequestDto.getClassTeaches() != 0) {
            teacher.setClassTeaches(teacherRequestDto.getClassTeaches());
        }
        if(teacherRequestDto.getTeacherId() != null) {
            teacher.setTeacherId(teacherRequestDto.getTeacherId());
        }
        Teacher teacherSaved = teacherRepository.save(teacher);

        return TeacherTransformer.teacherToTeacherResponseDto(teacherSaved);
    }
}
