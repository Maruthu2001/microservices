package com.auth.check.json_check.studiesFolder.JavaRunFiles;

import java.time.Duration;
import java.util.Map;

import org.apache.catalina.util.RateLimiter;

import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;

public class APIRateLimiter {
    
//    private final Map<String, RateLimiter> rateLimiters;
//
//    public APIRateLimiter() {
//        RateLimiterConfig userConfig = RateLimiterConfig.custom()
//                .limitForPeriod(1000)
//                .limitRefreshPeriod(Duration.ofMinutes(1))
//                .timeoutDuration(Duration.ofMillis(0))
//                .build();
//
//        RateLimiterConfig adminConfig = RateLimiterConfig.custom()
//                .limitForPeriod(10000)
//                .limitRefreshPeriod(Duration.ofMinutes(1))
//                .timeoutDuration(Duration.ofMillis(0))
//                .build();
//
//        rateLimiters = Map.of(
//                "user", RateLimiter.of("userLimiter", userConfig),
//                "admin", RateLimiter.of("adminLimiter", adminConfig)
//        );
//    }
//
//    public void handleRequest(String role) {
//        RateLimiter limiter = rateLimiters.getOrDefault(role, rateLimiters.get("user"));
//        RateLimiterRegistry registry = RateLimiterRegistry.of(limiter.getRateLimiterConfig());
//
//        Runnable restrictedCall = RateLimiter.decorateRunnable(limiter, () ->
//                System.out.println(role + " API call accepted")
//        );
//
//        try {
//            restrictedCall.run();
//        } catch (Exception e) {
//            System.out.println(role + " rate limit exceeded");
//        }
//    }
//
//    public static void main(String[] args) {
//        ApiRateLimiter service = new ApiRateLimiter();
//
//        // Simulating API calls
//        for (int i = 0; i < 1005; i++) {
//            service.handleRequest("user");
//        }
//
//        for (int i = 0; i < 10005; i++) {
//            service.handleRequest("admin");
//        }
//    }
}
