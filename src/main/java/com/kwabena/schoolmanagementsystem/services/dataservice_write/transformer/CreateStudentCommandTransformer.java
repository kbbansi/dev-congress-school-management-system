package com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer;

import com.kwabena.schoolmanagementsystem.domain.command.CreateStudentCommand;
import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.dto.request.CreateStudentRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateStudentCommandTransformer implements Transformer<CreateStudentCommand,
        CreateStudentRequest> {
    @Override
    public CreateStudentCommand transform(CreateStudentRequest request) {
        return CreateStudentCommand.builder()
                .name(request.getName())
                .email(request.getEmail())
                .studentID(RefData.generateStudentID())
                .build();
    }
}
