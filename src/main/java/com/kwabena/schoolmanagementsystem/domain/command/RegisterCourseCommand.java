package com.kwabena.schoolmanagementsystem.domain.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterCourseCommand {
    private String registrationID;
    private String studentID;
    private String courseID;
}
