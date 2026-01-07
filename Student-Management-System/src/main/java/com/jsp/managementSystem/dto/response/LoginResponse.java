package com.jsp.managementSystem.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private String Token;
    private  String expiresIn;
}
