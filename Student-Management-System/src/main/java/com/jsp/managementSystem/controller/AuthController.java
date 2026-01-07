package com.jsp.managementSystem.controller;

import com.jsp.managementSystem.dto.request.LoginRequest;
import com.jsp.managementSystem.dto.request.RegisterRequest;
import com.jsp.managementSystem.dto.response.AuthResponse;
import com.jsp.managementSystem.entity.Student;
import com.jsp.managementSystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
   private final AuthService authService;
   public AuthController(AuthService authService){
       this.authService=authService;
   }
   @PostMapping("/register")
public ResponseEntity<AuthResponse> registerUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
   }

   @PostMapping("/login")
    public  ResponseEntity<AuthResponse> loginUser(@RequestBody LoginRequest loginRequest){
       return ResponseEntity.status(HttpStatus.CREATED).body(authService.login(loginRequest));
   }
  @GetMapping("/showAll")
  public ResponseEntity<Student> showAll(Authentication authentication){
String name=authentication.getName();
      System.out.println(name);
   Student student=authService.loadStudentByMail(name);
        return ResponseEntity.ok(student);
  }

}
