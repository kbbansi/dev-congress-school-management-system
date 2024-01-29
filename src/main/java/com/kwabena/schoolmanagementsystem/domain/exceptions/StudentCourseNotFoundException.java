package com.kwabena.schoolmanagementsystem.domain.exceptions;

public class StudentCourseNotFoundException extends DomainException {
    public StudentCourseNotFoundException(String id) {
        super("StudentCourse with ID " + id + " not found");
    }
}
