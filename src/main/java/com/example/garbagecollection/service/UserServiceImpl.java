package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllDrivers() {
        return userRepository.findAll();
    }

    @Override
    public User createDriver(UserRequestDTO userRequestDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());  // No encryption for now
        user.setRole(User.UserRole.DRIVER);
        user.setStatus(User.UserStatus.ACTIVE);

        return userRepository.save(user);
    }

    @Override
    public User getDriverById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
    }
}
