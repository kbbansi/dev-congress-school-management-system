package com.kwabena.schoolmanagementsystem.domain.exceptions;

public class StudentNotFoundException  extends DomainException {
    public StudentNotFoundException(String studentID) {
        super("Student with ID " + studentID + " not found");
    }
}
