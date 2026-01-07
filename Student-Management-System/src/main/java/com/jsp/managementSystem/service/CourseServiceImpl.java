package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.AddCourse;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;
import com.jsp.managementSystem.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    public Course addCourse(AddCourse addCourse){
        if(courseRepository.existsById((addCourse.getCourseId()))){
            throw new RuntimeException(("Course exists"));
        }
        Course course=Course.builder()
                .courseId(addCourse.getCourseId())
                .courseFee((addCourse.getCourseFee()))
                .courseName(addCourse.getCourseName())
                .build();

        CourseResponse saveCourse=courseRepository.save(course);
        return CourseResponse.builder()
                .name(saveCourse.getCourseName())
                .build();


    }
}
