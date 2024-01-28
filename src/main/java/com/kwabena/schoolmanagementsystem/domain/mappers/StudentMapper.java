package com.kwabena.schoolmanagementsystem.domain.mappers;

import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.dto.response.StudentDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentMapper {

    private final ModelMapper mapper;


    public StudentResponseDto mapStudentToStudentResponseDto(Student student) {
        return mapper.map(student, StudentResponseDto.class);
    }

    public List<StudentResponseDto> studentResponseDtoList(List<Student> students) {
        return students.stream()
                .map(this::mapStudentToStudentResponseDto)
                .collect(Collectors.toList());
    }

    // more student methods
    public StudentDetailsDto mapStudentToStudentDetailsDto(Student student) {
        return mapper.map(student, StudentDetailsDto.class);
    }
}
