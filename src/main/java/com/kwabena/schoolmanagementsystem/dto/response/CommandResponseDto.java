package com.kwabena.schoolmanagementsystem.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandResponseDto {
    private String status;
    private String message;
}
