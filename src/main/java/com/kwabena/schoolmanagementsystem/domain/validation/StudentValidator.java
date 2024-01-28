package com.kwabena.schoolmanagementsystem.domain.validation;

import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.dto.request.CreateStudentRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StudentValidator extends BaseDomainValidator <CreateStudentRequest> {

    EmailValidator emailValidator;
    private RefData refData;

    /**
     * @param request to be validated
     */
    @Override
    protected void validate(CreateStudentRequest request) {
        Validate.notNull(request, "request cannot be null");
        Validate.notEmpty(request.getName(), "name cannot be empty");
        Validate.notEmpty(request.getEmail(), "email cannot be empty");
        Validate.isTrue(emailValidator.isValid(request.getEmail()), "email is not valid");

        Validate.isTrue(!refData.checkEmailExists(request.getEmail()), "email already exists");
    }
}
