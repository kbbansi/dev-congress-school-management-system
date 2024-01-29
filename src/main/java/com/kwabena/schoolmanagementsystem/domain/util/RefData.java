package com.kwabena.schoolmanagementsystem.domain.util;

import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.entities.StudentCourse;
import com.kwabena.schoolmanagementsystem.domain.exceptions.CourseNotFoundException;
import com.kwabena.schoolmanagementsystem.domain.exceptions.StudentCourseExistException;
import com.kwabena.schoolmanagementsystem.domain.exceptions.StudentNotFoundException;
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

    public static String generateRegistrationID() {
        return "DCSR" + RefData.generateUUID().toUpperCase();
    }

    public boolean checkStudentExists(String studentID) {
        return studentRepository.findStudentByStudentID(studentID).isPresent();
    }

    public boolean checkCourseExists(String courseID) {
        return courseRepository.findCourseByCourseID(courseID).isPresent();
    }

    public Student getStudent(String studentID) {
        return studentRepository.findStudentByStudentID(studentID).orElseThrow(() -> new StudentNotFoundException(studentID));
    }

    public Course getCourse(String courseID) {
        return courseRepository.findCourseByCourseID(courseID).orElseThrow(() -> new CourseNotFoundException(courseID));
    }

    public boolean checkStudentCourseExists(String studentID, String courseID) {
        Student student = studentRepository.findStudentByStudentID(studentID).orElseThrow(() -> new StudentNotFoundException(studentID));
        StudentCourse studentCourse = student.getStudentCourses()
                                            .stream()
                                            .filter(course -> course.getCourse().getCourseID().equals(courseID))
                                            .findFirst().orElse(null);
        return studentCourse != null;
    }

}
