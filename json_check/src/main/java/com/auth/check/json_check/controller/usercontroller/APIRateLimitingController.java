package com.auth.check.json_check.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.check.json_check.service.userService.ApiService;

@RestController
@RequestMapping("/api")
public class APIRateLimitingController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/user")
    public String userEndpoint() {
        return apiService.userApiCall();
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return apiService.adminApiCall();
    }
}
