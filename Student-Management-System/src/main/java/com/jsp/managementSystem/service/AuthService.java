package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.LoginRequest;
import com.jsp.managementSystem.dto.request.RegisterRequest;
import com.jsp.managementSystem.dto.response.AuthResponse;
import com.jsp.managementSystem.entity.Student;
import org.jspecify.annotations.Nullable;

public interface AuthService {
    @Nullable AuthResponse register(RegisterRequest registerRequest);
    @Nullable AuthResponse login(LoginRequest loginRequest);
    Student loadStudentByMail(String mail);
}
