package com.kwabena.schoolmanagementsystem.services.dataservice_write;

public abstract class BaseCommandRequestService<R, C, T> {
    public T processRequest(R request) {
        validate(request);
        C command = convertToCommand(request);
        save(command);
        return createCommandResponseDto(command);
    }

    protected abstract void validate(R request);

    protected abstract C convertToCommand(R request);

    protected abstract void save(C command);

    protected abstract T createCommandResponseDto(C command);
}
