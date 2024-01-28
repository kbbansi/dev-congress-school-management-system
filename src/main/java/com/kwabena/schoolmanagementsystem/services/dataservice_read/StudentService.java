package com.kwabena.schoolmanagementsystem.services.dataservice_read;

import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.mappers.StudentMapper;
import com.kwabena.schoolmanagementsystem.dto.response.StudentResponseDto;
import com.kwabena.schoolmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.studentResponseDtoList(students);
    }
}
