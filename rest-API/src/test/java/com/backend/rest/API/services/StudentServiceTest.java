package com.backend.rest.API.services;

import com.backend.rest.API.dtos.StudentGetDto;
import com.backend.rest.API.dtos.StudentPostDto;
import com.backend.rest.API.entities.StudentEntity;
import com.backend.rest.API.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void shouldAddStudentSuccessfullyGivenProperStudent(){

        StudentPostDto studentPostDto = new StudentPostDto();
        studentPostDto.setFirstName("Leod");
        studentPostDto.setPassword("12345");

        StudentEntity mockStudentEntity= new StudentEntity();
        mockStudentEntity.setPassword("12345");
        mockStudentEntity.setFirstName("Leod");
        UUID studentId = UUID.randomUUID();
        mockStudentEntity.setId(studentId);


        when(studentRepository.save(any())).thenReturn(mockStudentEntity);

        StudentGetDto studentGetDto = studentService.createStudent(studentPostDto);

        assertEquals(studentGetDto.getFirstName(), "Leod");
        assertEquals(studentGetDto.getId(), studentId.toString());
    }
}
