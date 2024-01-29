package com.kwabena.schoolmanagementsystem.domain.exceptions;

public class StudentCourseExistException extends DomainException {
    public StudentCourseExistException(String studentID) {
        super("Student with ID " + studentID + " already registered for a course");
    }
}
