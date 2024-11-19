package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.Driver;
import com.example.garbagecollection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return userRepository.findAll();
    }

    @Override
    public Driver createDriver(UserRequestDTO userRequestDTO) {
        Driver driver = new Driver();
        driver.setName(userRequestDTO.getName());
        driver.setContactInfo(userRequestDTO.getContactInfo());
        driver.setAssignedVehicle(userRequestDTO.getAssignedVehicle());
        return userRepository.save(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));
    }
}
