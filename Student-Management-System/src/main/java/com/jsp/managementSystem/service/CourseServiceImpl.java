package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.CourseRequest;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;
import com.jsp.managementSystem.repo.CourseRepository;
import com.jsp.managementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CourseResponse addCourse(CourseRequest courseRequest) {

        if (courseRepository.existsByCourseName(courseRequest.getCourseName())) {
            throw new RuntimeException("Course already exists");
        }

        Course course = Course.builder()
                .courseName(courseRequest.getCourseName())
                .courseFee(courseRequest.getCourseFee())
                .build();

       Course savedCourse= courseRepository.save(course);
        return CourseResponse.builder()
                .name(savedCourse.getCourseName()).build();
    }
}
