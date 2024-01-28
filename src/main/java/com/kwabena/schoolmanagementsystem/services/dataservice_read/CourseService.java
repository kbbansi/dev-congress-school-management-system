package com.kwabena.schoolmanagementsystem.services.dataservice_read;

import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import com.kwabena.schoolmanagementsystem.domain.exceptions.CourseNotFoundException;
import com.kwabena.schoolmanagementsystem.domain.mappers.CourseMapper;
import com.kwabena.schoolmanagementsystem.dto.response.CourseDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.CourseResponseDto;
import com.kwabena.schoolmanagementsystem.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.courseResponseDtoList(courses);
    }

    public CourseDetailsDto getCourseById(String id) {
        Course course = courseRepository.findCourseByCourseID(id).orElseThrow(() -> new CourseNotFoundException(id));
        return courseMapper.mapCourseToCourseDetailsDto(course);
    }
}
