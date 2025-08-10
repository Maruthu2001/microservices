package com.auth.check.json_check.controller.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.check.json_check.dto.JwtResponse;
import com.auth.check.json_check.dto.LoginRequest;
import com.auth.check.json_check.dto.RegisterRequest;
import com.auth.check.json_check.entity.User;
import com.auth.check.json_check.security.jwt.JwtUtils;
import com.auth.check.json_check.service.customevent.CustomEvent;
import com.auth.check.json_check.service.userService.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Basic Auth Controller", description = "Just Check")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
  
    @Autowired
    ApplicationEventPublisher aep;

    @PostMapping(value =  "/login")
    @Operation(summary = "Login", description = "Login and give a jwt token")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        aep.publishEvent(new CustomEvent("Dinesh Custom Event"));
        String jwt = jwtUtils.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest registerRequest) {
        User user = userService.registerUser(registerRequest);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getString")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved data item")
    public String getString() {
        return "Hi";
    }
  
}
