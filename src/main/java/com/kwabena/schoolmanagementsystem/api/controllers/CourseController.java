package com.kwabena.schoolmanagementsystem.api.controllers;

import com.kwabena.schoolmanagementsystem.dto.request.CreateCourseRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.dto.response.CourseDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.CourseResponseDto;
import com.kwabena.schoolmanagementsystem.services.dataservice_read.CourseService;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.CreateCourseRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@AllArgsConstructor
public class CourseController {

    private final CreateCourseRequestService createCourseRequestService;
    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CommandResponseDto> handlePost(@RequestBody CreateCourseRequest request) {
        CommandResponseDto responseDto = createCourseRequestService.processRequest(request);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponseDto>> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailsDto> getCourseById(@PathVariable String id) {
        return new ResponseEntity<>(courseService.getCourseById(id), HttpStatus.OK);
    }
}
