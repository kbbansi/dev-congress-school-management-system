package com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer;

import com.kwabena.schoolmanagementsystem.domain.command.CreateCourseCommand;
import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.dto.request.CreateCourseRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateCourseCommandTransformer implements Transformer<CreateCourseCommand,
        CreateCourseRequest> {
    @Override
    public CreateCourseCommand transform(CreateCourseRequest request) {
        return CreateCourseCommand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .creditHours(request.getCreditHours())
                .courseID(RefData.generateCourseID())
                .code(RefData.generateCourseCode(request.getName()))
                .build();
    }
}
