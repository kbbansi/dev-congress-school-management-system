package com.kwabena.schoolmanagementsystem.domain.mappers;

import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.entities.StudentCourse;
import com.kwabena.schoolmanagementsystem.dto.response.CourseDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.CourseResponseDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentResponseDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CourseMapper {

    private final ModelMapper mapper;

    public CourseResponseDto mapCourseToCourseResponseDto(Course course) {
        return mapper.map(course, CourseResponseDto.class);
    }

    public List<CourseResponseDto> courseResponseDtoList(List<Course> courses) {
        return courses.stream()
                .map(this::mapCourseToCourseResponseDto)
                .collect(Collectors.toList());
    }

    public CourseDetailsDto mapCourseToCourseDetailsDto(Course course) {
        List<StudentDetailsDto> studentDetailsDtos = mapStudentCoursesToStudentDetails(course.getStudentCourses());
        return CourseDetailsDto.builder()
                .courseID(course.getCourseID())
                .creditHours(course.getCreditHours())
                .description(course.getDescription())
                .code(course.getCode())
                .size(studentDetailsDtos.size())
                .students(studentDetailsDtos)
                .name(course.getName())
                .build();
    }

    private List<StudentDetailsDto> mapStudentCoursesToStudentDetails(Set<StudentCourse> studentCourses) {
        return studentCourses.stream()
                .map(this::mapStudentCourseToStudentDetails)
                .collect(Collectors.toList());
    }

    private StudentDetailsDto mapStudentCourseToStudentDetails(StudentCourse studentCourse) {
        Student student = studentCourse.getStudent();
        return StudentDetailsDto.builder()
                .studentID(student.getStudentID())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }
}
