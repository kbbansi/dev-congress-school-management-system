package com.kwabena.schoolmanagementsystem.services.dataservice_write;

import com.kwabena.schoolmanagementsystem.domain.command.CreateCourseCommand;
import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import com.kwabena.schoolmanagementsystem.domain.validation.CourseValidator;
import com.kwabena.schoolmanagementsystem.dto.request.CreateCourseRequest;
import com.kwabena.schoolmanagementsystem.dto.response.CommandResponseDto;
import com.kwabena.schoolmanagementsystem.repository.CourseRepository;
import com.kwabena.schoolmanagementsystem.services.dataservice_write.transformer.CreateCourseCommandTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CreateCourseRequestService extends BaseCommandRequestService<CreateCourseRequest,
        CreateCourseCommand, CommandResponseDto> {

    private final CreateCourseCommandTransformer transformer;
    private final CourseRepository courseRepository;
    private final CourseValidator courseValidator;

    @Value("${base.api.url}")
    private String baseApiUrl;

    /**
     * @param request to be validated
     */
    @Override
    protected void validate(CreateCourseRequest request) {
        courseValidator.validateRequest(request);
    }

    /**
     * @param request to be converted to domain command
     * @return create course command
     */
    @Override
    protected CreateCourseCommand convertToCommand(CreateCourseRequest request) {
        return transformer.transform(request);
    }

    /**
     * @param command persist course to database
     */
    @Override
    protected void save(CreateCourseCommand command) {
        this.saveCourse(command);
    }

    /**
     * @param command to return to client
     * @return create course response
     */
    @Override
    protected CommandResponseDto createCommandResponseDto(CreateCourseCommand command) {
        return CommandResponseDto.builder()
                                 .status("successful")
                                 .message(baseApiUrl + "courses/" + command.getCourseID())
                                 .build();
    }

    private void saveCourse(CreateCourseCommand command) {
        Course course = Course.builder()
                            .courseID(command.getCourseID())
                            .name(command.getName())
                            .description(command.getDescription())
                            .creditHours(command.getCreditHours())
                            .code(command.getCode())
                            .build();
        courseRepository.save(course);
    }
}
