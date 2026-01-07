package com.jsp.managementSystem.repo;

import com.jsp.managementSystem.entity.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {

}
