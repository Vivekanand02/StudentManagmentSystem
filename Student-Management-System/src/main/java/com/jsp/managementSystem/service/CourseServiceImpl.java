package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.CourseRequest;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;
import com.jsp.managementSystem.repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .name(savedCourse.getCourseName())
                .fee(savedCourse.getCourseFee()).build();
    }

    @Override
    public List getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findByCourseId(int courseId) {
        return courseRepository.findByCourseId(courseId);
    }

    @Override
    public Course updateCourse(int courseId,CourseRequest courseRequest){
        Course existing=courseRepository.findByCourseId(courseId)
                .orElseThrow(()-> new RuntimeException("Course not found"));
        existing.setCourseName(courseRequest.getCourseName());
        existing.setCourseFee((courseRequest.getCourseFee()));
        return courseRepository.save(existing);
    }
    public void deleteCourse(int courseId){
        if(!courseRepository.existsById((long) courseId)){
          throw new RuntimeException("Course not found");
        }
         courseRepository.deleteById((long) courseId);
    }
}
