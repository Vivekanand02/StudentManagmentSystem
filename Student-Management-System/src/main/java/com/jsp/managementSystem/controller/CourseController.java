package com.jsp.managementSystem.controller;

import com.jsp.managementSystem.dto.request.CourseRequest;
import com.jsp.managementSystem.dto.response.CourseResponse;
import com.jsp.managementSystem.entity.Course;
import com.jsp.managementSystem.repo.CourseRepository;
import com.jsp.managementSystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
@GetMapping("/findBy/courseName")
    public Optional<Course> findByCourseId(@RequestParam int courseId){
        return courseService.findByCourseId(courseId);
}
@PutMapping("/updateBy/{courseId}")
    public ResponseEntity<Course> updateCourse(@PathVariable int courseId, @RequestBody CourseRequest courseRequest){
       Course updatedCourse=courseService.updateCourse(courseId,courseRequest);
       return ResponseEntity.ok(updatedCourse);
}
@DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
}
}
