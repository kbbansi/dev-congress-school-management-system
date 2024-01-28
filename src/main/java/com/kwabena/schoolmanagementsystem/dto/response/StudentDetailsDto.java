package com.kwabena.schoolmanagementsystem.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class StudentDetailsDto {
    private String name;
    private String email;
    private String studentID;
    private Set<CourseResponseDto> courses;
}
