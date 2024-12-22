package com.example.garbagecollection.controller;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllDrivers() {

        return ResponseEntity.ok(userService.getAllDrivers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getDriverById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getDriverById(id));
    }
    @GetMapping("/{name}")
    public List<User> getDriversByName(@PathVariable String name) {
        return userService.getDriversByName(name);
    }
    @GetMapping("/dash")
    @PreAuthorize("hasAuthority('DRIVER')")
    public String DriverScreen() {
        return "Welcome to the driver homepage";
    }
    @PostMapping
    public ResponseEntity<User> createDriver(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createDriver(userRequestDTO));
    }
    @PutMapping("/{id}")
    public User updateDriver(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateDriver(id, userRequestDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable Long id) {
        userService.deleteDriver(id);
    }


}

@RestController
@RequestMapping("/api/customers")

class CustomerController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllCustomers() {

        return ResponseEntity.ok(userService.getAllCustomers());
    }
    @GetMapping("/{id}")
    public User getCustomerById(@PathVariable Long id) {
        return userService.getCustomerById(id);
    }
    @GetMapping("/{name}")
    public List<User> getCustomersByName(@PathVariable String name) {
        return userService.getCustomersByName(name);
    }
    @GetMapping("/dash")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public String CustomerScreen() {
        return "Welcome to the customer homepage";
    }
    @PostMapping
    public ResponseEntity<User> createCustomer(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createCustomer(userRequestDTO));
    }
    @PutMapping("/{id}")
    public User updateCustomer(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateCustomer(id, userRequestDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        userService.deleteCustomer(id);
    }


}




@RestController
@RequestMapping("/api/admins")

class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllAdmins() {

        return ResponseEntity.ok(userService.getAllAdmins());
    }

    @GetMapping("/{id}")
    public User getAdminById(@PathVariable Long id) {
        return userService.getAdminById(id);
    }
    @GetMapping("/{name}")
    public List<User> getAdminsByName(@PathVariable String name) {
        return userService.getAdminsByName(name);
    }
    @GetMapping("/dash")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String AdminScreen() {
        return "Welcome to the ADMIN homepage";
    }
    @PostMapping
    public ResponseEntity<User> createAdmin(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.createAdmin(userRequestDTO));
    }
    @PutMapping("/{id}")
    public User updateAdmin(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateAdmin(id, userRequestDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        userService.deleteAdmin(id);
    }



}