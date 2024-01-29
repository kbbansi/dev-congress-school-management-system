package com.kwabena.schoolmanagementsystem.domain.validation;

import com.kwabena.schoolmanagementsystem.domain.entities.StudentCourse;
import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.dto.request.RegisterCourseRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisterCourseValidator extends BaseDomainValidator <RegisterCourseRequest> {

    private RefData refData;
    @Override
    protected void validate(RegisterCourseRequest request) {
        Validate.notNull(request, "request cannot be null");
        Validate.notEmpty(request.getStudentID(), "studentID cannot be empty");
        Validate.notEmpty(request.getCourseID(), "courseID cannot be empty");

        Validate.isTrue(refData.checkStudentExists(request.getStudentID()), "studentID does not exists");
        Validate.isTrue(refData.checkCourseExists(request.getCourseID()), "courseID does not exists");

        // check if student is already registered for the course
        boolean isRegistered = refData.checkStudentCourseExists(request.getStudentID(), request.getCourseID());
        Validate.isTrue(!isRegistered, "student is already registered for the course");

    }
}
