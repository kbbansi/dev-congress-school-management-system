package com.kwabena.schoolmanagementsystem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterCourseRequest {
    private String studentID;
    private String courseID;
}
