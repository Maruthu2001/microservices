package com.auth.check.json_check.service.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.check.json_check.dto.RegisterRequest;
import com.auth.check.json_check.entity.Role;
import com.auth.check.json_check.entity.User;
import com.auth.check.json_check.repository.roleRepository.RoleRepository;
import com.auth.check.json_check.repository.userRepository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        for (String rol : request.getRoleNames()) {
            Role userRole = roleRepository.findByName(rol).orElseThrow(() -> new RuntimeException("Role Not Found!!"));
            user.getRoles().add(userRole);
        }
        return userRepository.save(user);
    }
}
