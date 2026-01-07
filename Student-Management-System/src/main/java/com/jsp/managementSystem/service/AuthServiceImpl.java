package com.jsp.managementSystem.service;

import com.jsp.managementSystem.dto.request.LoginRequest;
import com.jsp.managementSystem.dto.request.RegisterRequest;
import com.jsp.managementSystem.dto.response.AuthResponse;
import com.jsp.managementSystem.entity.Student;
import com.jsp.managementSystem.repo.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


       private final StudentRepository studentRepository;
       private PasswordEncoder passwordEncoder;
       private AuthenticationManager authenticationManager;

       @Override
       public  AuthResponse register(RegisterRequest registerRequest){
           if(studentRepository.existsByMail(registerRequest.getEmail())){
               throw new RuntimeException(("email exists"));
           }
          Student student =Student.builder()
                  .stdName(registerRequest.getName())
                  .password(registerRequest.getPassword())
                  .dob(registerRequest.getDateOfBirth().atStartOfDay())
                  .phone(registerRequest.getPhone())
                  .password(registerRequest.getPassword())
                  .mail(registerRequest.getEmail())
                  .build();
           Student saveStudent=studentRepository.save(student);
           AuthResponse authResponse=AuthResponse.builder()
           .name(saveStudent.getStdName())
                   .mail(saveStudent.getMail())
                   .build();
           return authResponse;


       }

    @Override
    public @Nullable AuthResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Student loadStudentByMail(String mail) {
        return null;
    }

}
