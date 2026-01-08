package com.jsp.managementSystem.repo;

import com.jsp.managementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    boolean existsByCourseName(String courseName);
}
