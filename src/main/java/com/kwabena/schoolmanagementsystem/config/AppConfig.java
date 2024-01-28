package com.kwabena.schoolmanagementsystem.config;

import org.apache.commons.validator.routines.EmailValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public EmailValidator emailValidator() {
        return EmailValidator.getInstance();
    }

    @Bean
    public String baseApiUrl(@Value("${base.api.url}") String baseApiUrl) {
        return baseApiUrl;
    }
}
