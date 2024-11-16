package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.DriverRequestDTO;
import com.example.garbagecollection.entity.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver createDriver(DriverRequestDTO driverRequestDTO);
    Driver getDriverById(Long id);
}
