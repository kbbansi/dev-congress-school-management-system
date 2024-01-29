package com.kwabena.schoolmanagementsystem.api.advice;

import com.kwabena.schoolmanagementsystem.domain.exceptions.DomainException;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommandResponseDto> handleException(RuntimeException e) {
        CommandResponseDto response = CommandResponseDto.builder()
                                                        .status("failed")
                                                        .message(e.getMessage())
                                                        .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommandResponseDto> handleException(DomainException e) {
        CommandResponseDto response = CommandResponseDto.builder()
                                                        .status("failed")
                                                        .message(e.getMessage())
                                                        .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
