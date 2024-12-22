package com.example.garbagecollection.controller;

import com.example.garbagecollection.dto.LoginRequestDTO;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.repository.UserRepository;
import com.example.garbagecollection.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "basicAuth")
@Tag(name = "Auth", description = "Endpoints for Auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil; // Inject JwtUtil

    @PostMapping("/signup")
    @Operation(summary = "signup users", description = "add new users")
    public String signup(@RequestBody UserRequestDTO signupRequest) {
        Optional<User> existingUser = userRepository.findByEmail(signupRequest.getEmail());
        if (existingUser.isPresent()) {
            return "User already exists";
        }

        User user = new User();
        user.setFirstName(signupRequest.getFirstName());
        user.setLastName(signupRequest.getLastName());
        user.setContactNumber(signupRequest.getContactNumber());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        if (signupRequest.getUserRole() != null) {
            user.setRole(User.UserRole.valueOf(signupRequest.getUserRole().toUpperCase()));
        } else {
            return "User role is required";
        }
        user.setStatus(User.UserStatus.ACTIVE);
        userRepository.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    @Operation(summary = "login users", description = "Allows access for authorized users to use the system")
    public String login(@RequestBody LoginRequestDTO loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return "Login successful. Token: " + token;
    }
}
