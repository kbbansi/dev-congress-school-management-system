package com.kwabena.schoolmanagementsystem.domain.validation;

public abstract class BaseDomainValidator<T> {

    public void validateRequest(T request) {
        validate(request);
    }

    protected abstract void validate(T request);
}
