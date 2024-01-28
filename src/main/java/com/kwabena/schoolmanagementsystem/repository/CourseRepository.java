package com.kwabena.schoolmanagementsystem.repository;

import com.kwabena.schoolmanagementsystem.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findCourseByCourseID(String courseID);
}
