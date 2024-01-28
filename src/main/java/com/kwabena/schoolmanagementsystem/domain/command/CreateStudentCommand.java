package com.kwabena.schoolmanagementsystem.domain.command;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateStudentCommand {
    private String name;
    private String email;
    private String studentID;
}
