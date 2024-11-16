package com.example.garbagecollection.controller;

import com.example.garbagecollection.dto.DriverRequestDTO;
import com.example.garbagecollection.entity.Driver;
import com.example.garbagecollection.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody DriverRequestDTO driverRequestDTO) {
        return ResponseEntity.ok(driverService.createDriver(driverRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(driverService.getDriverById(id));
    }
}
