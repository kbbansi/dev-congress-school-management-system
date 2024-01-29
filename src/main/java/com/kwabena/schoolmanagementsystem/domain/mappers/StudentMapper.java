package com.kwabena.schoolmanagementsystem.domain.mappers;

import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.entities.StudentCourse;
import com.kwabena.schoolmanagementsystem.dto.response.CourseResponseDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class StudentMapper {

    private final ModelMapper mapper;
    private final CourseMapper courseMapper;


    public StudentResponseDto mapStudentToStudentResponseDto(Student student) {
        return mapper.map(student, StudentResponseDto.class);
    }

    public List<StudentResponseDto> studentResponseDtoList(List<Student> students) {
        return students.stream()
                .map(this::mapStudentToStudentResponseDto)
                .collect(Collectors.toList());
    }

    public StudentDetailsDto mapStudentToStudentDetailsDto(Student student) {
        Set<CourseResponseDto> studentCourses = mapStudentCoursesToStudentDetails(student.getStudentCourses());
        return StudentDetailsDto.builder()
                .studentID(student.getStudentID())
                .name(student.getName())
                .email(student.getEmail())
                .courses(studentCourses)
                .build();
    }

    private Set<CourseResponseDto> mapStudentCoursesToStudentDetails(Set<StudentCourse> studentCourses) {
        return studentCourses.stream()
                .map(studentCourse -> courseMapper.mapCourseToCourseResponseDto(studentCourse.getCourse()))
                .collect(Collectors.toSet());
    }
}
