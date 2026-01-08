package com.jsp.managementSystem.repo;

import com.jsp.managementSystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CourseRepository extends JpaRepository<Course,Long> {
    boolean existsByCourseName(String courseName);
}
