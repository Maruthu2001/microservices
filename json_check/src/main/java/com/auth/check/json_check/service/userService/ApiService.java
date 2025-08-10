package com.auth.check.json_check.service.userService;

import org.springframework.stereotype.Service;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class ApiService {

    @RateLimiter(name = "userLimiter", fallbackMethod = "userFallback")
    public String userApiCall() {
        return "User API call successful";
    }

    @RateLimiter(name = "adminLimiter", fallbackMethod = "adminFallback")
    public String adminApiCall() {
        return "Admin API call successful";
    }

    public String userFallback(RequestNotPermitted ex) {
        return "User rate limit exceeded. Try again later.";
    }

    public String adminFallback(RequestNotPermitted ex) {
        return "Admin rate limit exceeded. Try again later.";
    }
}