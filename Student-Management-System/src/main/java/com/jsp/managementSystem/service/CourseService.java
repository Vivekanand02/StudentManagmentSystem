package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.CourseRequest;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;

public interface CourseService {
    public CourseResponse addCourse(CourseRequest courseRequest);
}
