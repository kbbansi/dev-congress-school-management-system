package com.kwabena.schoolmanagementsystem.domain.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateCourseCommand {
    private String name;
    private String description;
    private Long creditHours;
    private String courseID;
    private String code;
}
