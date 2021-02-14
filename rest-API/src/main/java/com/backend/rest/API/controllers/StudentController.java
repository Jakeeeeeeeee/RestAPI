package com.backend.rest.API.controllers;

import com.backend.rest.API.dtos.StudentGetDto;
import com.backend.rest.API.dtos.StudentPostDto;
import com.backend.rest.API.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentGetDto> createStudent(@RequestBody StudentPostDto studentPostDto) {
        StudentGetDto studentGetDto = studentService.createStudent(studentPostDto);


        return ResponseEntity.ok(studentGetDto);
    }
}
