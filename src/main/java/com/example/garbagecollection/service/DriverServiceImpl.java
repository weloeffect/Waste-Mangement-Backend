package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.DriverRequestDTO;
import com.example.garbagecollection.entity.Driver;
import com.example.garbagecollection.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Driver createDriver(DriverRequestDTO driverRequestDTO) {
        Driver driver = new Driver();
        driver.setName(driverRequestDTO.getName());
        driver.setContactInfo(driverRequestDTO.getContactInfo());
        driver.setAssignedVehicle(driverRequestDTO.getAssignedVehicle());
        return driverRepository.save(driver);
    }

    @Override
    public Driver getDriverById(Long id) {
        return driverRepository.findById(id).orElseThrow(() -> new RuntimeException("Driver not found"));
    }
}
