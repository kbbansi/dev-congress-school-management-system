package com.kwabena.schoolmanagementsystem.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateStudentRequest {
    private String name;
    private String email;
}
