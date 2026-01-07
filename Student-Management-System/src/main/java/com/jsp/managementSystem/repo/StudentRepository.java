package com.jsp.managementSystem.repo;

import com.jsp.managementSystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByMail(String mail);
    boolean existsByMail(String mail);
}
