package com.jsp.managementSystem.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {
    private String name;
    private String mail;
    private String token;
    private String  expiresIn;
}