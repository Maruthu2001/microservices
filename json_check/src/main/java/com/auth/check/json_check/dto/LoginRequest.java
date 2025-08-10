package com.auth.check.json_check.dto;


import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
