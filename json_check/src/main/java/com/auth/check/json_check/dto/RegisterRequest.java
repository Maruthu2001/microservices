package com.auth.check.json_check.dto;

import java.util.Set;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Set<String> roleNames;
}
