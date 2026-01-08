package com.jsp.managementSystem.controller;

import com.jsp.managementSystem.dto.request.CourseRequest;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;
import com.jsp.managementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/addCourse")
    public ResponseEntity<CourseResponse> addCourse(@RequestBody CourseRequest courseRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body((CourseResponse) courseService.addCourse(courseRequest));
    }
@GetMapping("/seeCourses")
public ResponseEntity<List<Course>> showCourses() {

    return ResponseEntity.ok(courseService.getAllCourses());
}




}
