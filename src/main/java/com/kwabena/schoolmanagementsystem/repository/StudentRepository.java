package com.kwabena.schoolmanagementsystem.repository;

import com.kwabena.schoolmanagementsystem.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByStudentID(String studentID);

    Optional<Student> findStudentByEmail(String email);
}
