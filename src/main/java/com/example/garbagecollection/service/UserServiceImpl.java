package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  // Import BCryptPasswordEncoder
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // Password encoder

    @Override
    public List<User> getAllDrivers() {
        return userRepository.findAll();  // Fetch all drivers from the repository
    }

    @Override
    public User createDriver(UserRequestDTO userRequestDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));  // Encrypt password
        user.setRole(User.UserRole.DRIVER);  // Default to DRIVER role
        user.setStatus(User.UserStatus.ACTIVE);  // Default to ACTIVE status

        // Save and return the user
        return userRepository.save(user);
    }

    @Override
    public User getDriverById(Long id) {
        // Fetch the user by ID, throw an exception if not found
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
    }
}
