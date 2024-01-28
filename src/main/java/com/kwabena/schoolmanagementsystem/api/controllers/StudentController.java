package com.kwabena.schoolmanagementsystem.api.controllers;

import com.kwabena.schoolmanagementsystem.dto.request.CreateStudentRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentDetailsDto;
import com.kwabena.schoolmanagementsystem.dto.response.StudentResponseDto;
import com.kwabena.schoolmanagementsystem.services.dataservice_read.StudentService;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.CreateStudentRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final CreateStudentRequestService createStudentRequestService;
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<CommandResponseDto> handlePost(@RequestBody CreateStudentRequest request) {
        CommandResponseDto responseDto = createStudentRequestService.processRequest(request);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDetailsDto> getStudentById(@PathVariable String id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }



}
