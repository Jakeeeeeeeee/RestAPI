package com.backend.rest.API.services;


import com.backend.rest.API.dtos.StudentGetDto;
import com.backend.rest.API.dtos.StudentPostDto;
import com.backend.rest.API.entities.StudentEntity;
import com.backend.rest.API.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentGetDto createStudent(StudentPostDto studentPostDto){

        StudentEntity studentEntity = this.mapPostDtoEntity(studentPostDto);
        StudentEntity saveStudentEntity = studentRepository.save(studentEntity);

        StudentGetDto studentGetDto = this.mapEntityToGetDto(saveStudentEntity);

        return  studentGetDto;
    }


    private StudentEntity mapPostDtoEntity(StudentPostDto studentPostDto){
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setFirstName(studentPostDto.getFirstName());
        studentEntity.setPassword(studentPostDto.getPassword());

        return studentEntity;
    }

        private StudentGetDto mapEntityToGetDto(StudentEntity studentEntity){
            StudentGetDto studentGetDto = new StudentGetDto();
            studentGetDto.setId(studentEntity.getId().toString());
            studentGetDto.setFirstName(studentEntity.getFirstName());

            return  studentGetDto;
        }
}
