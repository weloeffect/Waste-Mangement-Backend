package com.example.garbagecollection.controller;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.Driver;
import com.example.garbagecollection.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Driver>> getAllDrivers() {
        return ResponseEntity.ok(userService.getAllDrivers());
    }

    @PostMapping
    public ResponseEntity<Driver> createDriver(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createDriver(userRequestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getDriverById(id));
    }
}
