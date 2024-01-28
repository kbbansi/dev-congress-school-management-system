package com.kwabena.schoolmanagementsystem.domain.exceptions;

public class StudentCourseNotFoundException extends DomainException {
    public StudentCourseNotFoundException(Long id) {
        super("StudentCourse with ID " + id + " not found");
    }
}
