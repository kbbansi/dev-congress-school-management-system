package com.kwabena.schoolmanagementsystem.domain.validation;

import com.kwabena.schoolmanagementsystem.dto.request.CreateCourseRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CourseValidator extends BaseDomainValidator <CreateCourseRequest> {
    /**
     * @param request to be validated
     */
    @Override
    protected void validate(CreateCourseRequest request) {
        Validate.notNull(request, "request cannot be null");
        Validate.notEmpty(request.getName(), "name cannot be empty");
        Validate.notEmpty(request.getDescription(), "description cannot be empty");
    }
}
