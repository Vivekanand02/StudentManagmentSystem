package com.jsp.managementSystem.dto.response;

import com.jsp.managementSystem.entity.Course;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseResponse {
    private String name;
}
