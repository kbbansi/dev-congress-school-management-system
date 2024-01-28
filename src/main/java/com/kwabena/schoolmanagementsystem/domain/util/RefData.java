package com.kwabena.schoolmanagementsystem.domain.util;

import com.kwabena.schoolmanagementsystem.repository.CourseRepository;
import com.kwabena.schoolmanagementsystem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefData {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
//    private final StudentCourseRepository studentCourseRepository;

    public static String generateUUID() {
        return java.util.UUID.randomUUID().toString().substring(0, 6);
    }

    public static Long generateRandomNumber() {
        // generate random number of not more than 4 digits
        return (long) (Math.random() * 10000);
    }

    public static String generateStudentID() {
        return "DCSMS" + RefData.generateUUID() + RefData.generateRandomNumber();
    }

    public boolean checkEmailExists(String email) {
        return studentRepository.findStudentByEmail(email).isPresent();
    }

    public static String generateCourseID() {
        return "DCSC" + RefData.generateUUID();
    }

    public static String generateCourseCode(String courseName) {
        return courseName.substring(0, 3).toUpperCase() + RefData.generateRandomNumber();
    }

}
