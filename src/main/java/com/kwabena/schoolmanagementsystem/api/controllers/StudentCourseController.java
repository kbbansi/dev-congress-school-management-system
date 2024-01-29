package com.kwabena.schoolmanagementsystem.api.controllers;

import com.kwabena.schoolmanagementsystem.dto.request.RegisterCourseRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.RegisterCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/register")
@AllArgsConstructor
public class StudentCourseController {

    private final RegisterCourseService registerCourseService;

    @PostMapping
    public ResponseEntity<CommandResponseDto> handlePost(@RequestBody RegisterCourseRequest request) {
        CommandResponseDto responseDto = registerCourseService.processRequest(request);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }


}
