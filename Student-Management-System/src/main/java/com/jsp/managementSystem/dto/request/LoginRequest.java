package com.jsp.managementSystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String email;
    String password;
}
