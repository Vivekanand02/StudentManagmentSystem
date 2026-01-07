package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.AddCourse;
import com.jsp.managementSystem.entity.Course;

public interface CourseService {
    public Course addCourse(AddCourse addCourse);
}
