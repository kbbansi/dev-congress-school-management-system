package com.kwabena.schoolmanagementsystem.domain.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RefData {

    public static String generateUUID() {
        return java.util.UUID.randomUUID().toString().substring(0, 6);
    }

    public static Long generateRandomNumber() {
        // generate random number of not more than 4 digits
        return (long) (Math.random() * 10000);
    }

    public static String generateStudentID() {
        return "DCSMS" + RefData.generateUUID() + RefData.generateRandomNumber();
    }
}
