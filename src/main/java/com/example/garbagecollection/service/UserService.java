package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllDrivers();
    User createDriver(UserRequestDTO userRequestDTO);
    User getDriverById(Long userId);
}
