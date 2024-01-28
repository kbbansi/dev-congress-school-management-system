package com.kwabena.schoolmanagementsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class StudentDetailsDto {
    private StudentResponseDto student;
    private Set<CourseResponseDto> courses;
}
