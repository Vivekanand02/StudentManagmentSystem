package com.jsp.managementSystem.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotEmpty
    private String name;
    @NotBlank
    @Email
    private String email;
    @Size(min = 10, max = 10, message = "Mobile number should be 10 digit only")
    private String phone;
    private String password;
    private String role;
    private LocalDate dateOfBirth;
}
