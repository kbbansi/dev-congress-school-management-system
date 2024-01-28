package com.kwabena.schoolmanagementsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponseDto {
    private String name;
    private String description;
    private Long creditHours;
    private String courseID;
    private String code;
}
