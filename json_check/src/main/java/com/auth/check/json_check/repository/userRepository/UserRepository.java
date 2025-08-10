package com.auth.check.json_check.repository.userRepository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auth.check.json_check.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByUsername(String username);
}
