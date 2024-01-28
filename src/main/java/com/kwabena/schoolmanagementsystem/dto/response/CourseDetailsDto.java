package com.kwabena.schoolmanagementsystem.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CourseDetailsDto {
    private String name;
    private String description;
    private Long creditHours;
    private String courseID;
    private String code;
    private List<StudentDetailsDto> students;
    private int size;
}
