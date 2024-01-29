package com.kwabena.schoolmanagementsystem.services.dataservice_write;

import com.kwabena.schoolmanagementsystem.domain.command.RegisterCourseCommand;
import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import com.kwabena.schoolmanagementsystem.domain.entities.StudentCourse;
import com.kwabena.schoolmanagementsystem.domain.util.RefData;
import com.kwabena.schoolmanagementsystem.domain.validation.RegisterCourseValidator;
import com.kwabena.schoolmanagementsystem.dto.request.RegisterCourseRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.repository.StudentCourseRepository;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer.RegisterCourseCommandTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RegisterCourseService extends BaseCommandRequestService<RegisterCourseRequest,
        RegisterCourseCommand, CommandResponseDto> {

    private final RegisterCourseCommandTransformer transformer;
    private final RegisterCourseValidator registerCourseValidator;
    private final StudentCourseRepository studentCourseRepository;
    private final RefData refData;

    @Value("${base.api.url}")
    private String baseApiUrl;


    /**
     * @param request to be validated
     */
    @Override
    protected void validate(RegisterCourseRequest request) {
        registerCourseValidator.validateRequest(request);
    }

    /**
     * @param request to be converted to domain command
     * @return student course command
     */
    @Override
    protected RegisterCourseCommand convertToCommand(RegisterCourseRequest request) {
        return transformer.transform(request);
    }

    /**
     * @param command persist student course to database
     */
    @Override
    protected void save(RegisterCourseCommand command) {
        saveStudentCourse(command);
    }

    /**
     * @param command to return to client
     * @return create student course response
     */
    @Override
    protected CommandResponseDto createCommandResponseDto(RegisterCourseCommand command) {
        return CommandResponseDto.builder()
                .status("success")
                .message(baseApiUrl +"register/" + command.getRegistrationID())
                .build();
    }

    private void saveStudentCourse(RegisterCourseCommand command) {
        Student student = refData.getStudent(command.getStudentID());
        Course course = refData.getCourse(command.getCourseID());
        StudentCourse studentCourse = StudentCourse.builder()
                .course(course)
                .student(student)
                .registrationID(command.getRegistrationID())
                .build();
        studentCourseRepository.save(studentCourse);
    }
}
