package com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer;

import com.kwabena.schoolmanagementsystem.domain.command.RegisterCourseCommand;
import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.dto.request.RegisterCourseRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterCourseCommandTransformer implements Transformer<RegisterCourseCommand,
        RegisterCourseRequest> {

    @Override
    public RegisterCourseCommand transform(RegisterCourseRequest request) {
        return RegisterCourseCommand.builder()
                .studentID(request.getStudentID())
                .courseID(request.getCourseID())
                .registrationID(RefData.generateRegistrationID())
                .build();
    }
}
