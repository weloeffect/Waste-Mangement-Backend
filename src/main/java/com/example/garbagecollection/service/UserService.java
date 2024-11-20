package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.Driver;

import java.util.List;

public interface UserService {
    List<Driver> getAllDrivers();
    Driver createDriver(UserRequestDTO userRequestDTO);
    Driver getDriverById(Long id);
}
