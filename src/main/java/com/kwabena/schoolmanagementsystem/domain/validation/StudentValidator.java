package com.kwabena.schoolmanagementsystem.domain.validation;

import com.kwabena.schoolmanagementsystem.dto.request.CreateStudentRequest;
import org.apache.commons.lang3.Validate;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator extends BaseDomainValidator <CreateStudentRequest> {

    EmailValidator emailValidator = EmailValidator.getInstance();

    /**
     * @param request to be validated
     */
    @Override
    protected void validate(CreateStudentRequest request) {
        Validate.notNull(request, "request cannot be null");
        Validate.notEmpty(request.getName(), "name cannot be empty");
        Validate.notEmpty(request.getEmail(), "email cannot be empty");
        Validate.isTrue(emailValidator.isValid(request.getEmail()), "email is not valid");

        //TODO::: check if email exits
    }
}
