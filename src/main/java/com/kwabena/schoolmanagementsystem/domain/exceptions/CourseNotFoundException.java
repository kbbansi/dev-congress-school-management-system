package com.kwabena.schoolmanagementsystem.domain.exceptions;

public class CourseNotFoundException extends DomainException{
    public CourseNotFoundException(String courseID) {
        super("Course with ID " + courseID + " not found");
    }
}
