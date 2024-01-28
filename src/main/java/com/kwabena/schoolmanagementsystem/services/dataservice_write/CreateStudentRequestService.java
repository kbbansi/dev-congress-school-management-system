package com.kwabena.schoolmanagementsystem.services.dataservice_write;

import com.kwabena.schoolmanagementsystem.domain.command.CreateStudentCommand;
import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.validation.StudentValidator;
import com.kwabena.schoolmanagementsystem.dto.request.CreateStudentRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.repository.StudentRepository;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer.CreateStudentCommandTransformer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CreateStudentRequestService extends BaseCommandRequestService<CreateStudentRequest,
        CreateStudentCommand, CommandResponseDto> {

    private final CreateStudentCommandTransformer transformer;
    private final StudentRepository studentRepository;
    private final StudentValidator studentValidator;

    @Value("${base.api.url}")
    private String baseApiUrl;

    /**
     * @param request to be validated
     */
    @Override
    protected void validate(CreateStudentRequest request) {
        studentValidator.validateRequest(request);
    }

    /**
     * @param request request to be converted to domain command
     * @return create student command
     */
    @Override
    protected CreateStudentCommand convertToCommand(CreateStudentRequest request) {
        return transformer.transform(request);
    }

    /**
     * @param command persist student to database
     */
    @Override
    protected void save(CreateStudentCommand command) {
        this.saveStudent(command);
    }

    /**
     * @param command to return to client
     * @return create student response
     */
    @Override
    protected CommandResponseDto createCommandResponseDto(CreateStudentCommand command) {
        return CommandResponseDto.builder()
                                 .status("successful")
                                 .message(baseApiUrl +"/students/" + command.getStudentID())
                                 .build();
    }

    private void saveStudent(CreateStudentCommand command) {
        Student student = Student.builder()
                                .studentID(command.getStudentID())
                                .name(command.getName())
                                .email(command.getEmail())
                                .build();
        studentRepository.save(student);
    }
}
