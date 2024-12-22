package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  // Import BCryptPasswordEncoder
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    //    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // Password encoder
// Driver Services
    @Override
    public List<User> getAllDrivers() {
        return userRepository.findByRole(User.UserRole.DRIVER);
    }

    @Override
    public User getDriverById(Long id) {
        return userRepository.findByIdAndRole(id, User.UserRole.DRIVER)
                .orElseThrow(() -> new RuntimeException("Driver not found with ID: " + id));
    }
    @Override
    public List<User> getDriversByName(String name) {
        return userRepository.findByFirstNameAndRole(name, User.UserRole.DRIVER);
    }
    @Override
    public User updateDriver(Long id, UserRequestDTO userRequestDTO) {
        User user = getDriverById(id); // Ensure the user exists and is a driver
        updateUserFields(user, userRequestDTO);
        return userRepository.save(user);
    }
    @Override
    public void deleteDriver(Long id) {
        User user = getDriverById(id);
        userRepository.delete(user);
    }
    @Override
    public User createDriver(UserRequestDTO userRequestDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));  // Encrypt password
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(User.UserRole.DRIVER);  // Default to DRIVER role
        user.setStatus(User.UserStatus.ACTIVE);  // Default to ACTIVE status

        // Save and return the user
        return userRepository.save(user);
    }

    // Customer Services
    @Override
    public List<User> getAllCustomers() {
        return userRepository.findByRole(User.UserRole.CUSTOMER);
    }
    @Override
    public User getCustomerById(Long id) {
        return userRepository.findByIdAndRole(id, User.UserRole.CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }
    @Override
    public List<User> getCustomersByName(String name) {
        return userRepository.findByFirstNameAndRole(name, User.UserRole.CUSTOMER);
    }
    @Override
    public User updateCustomer(Long id, UserRequestDTO userRequestDTO) {
        User user = getCustomerById(id); // Ensure the user exists and is a customer
        updateUserFields(user, userRequestDTO);
        return userRepository.save(user);
    }
    @Override
    public void deleteCustomer(Long id) {
        User user = getCustomerById(id);
        userRepository.delete(user);
    }
    @Override
    public User createCustomer(UserRequestDTO userRequestDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));  // Encrypt password
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(User.UserRole.CUSTOMER);  // Default to DRIVER role
        user.setStatus(User.UserStatus.ACTIVE);  // Default to ACTIVE status

        // Save and return the cus
        return userRepository.save(user);
    }

    // Admin services
    @Override
    public List<User> getAllAdmins() {
        return userRepository.findByRole(User.UserRole.ADMIN);
    }
    @Override
    public User getAdminById(Long id) {
        return userRepository.findByIdAndRole(id, User.UserRole.ADMIN)
                .orElseThrow(() -> new RuntimeException("Admin not found with ID: " + id));
    }
    @Override
    public List<User> getAdminsByName(String name) {
        return userRepository.findByFirstNameAndRole(name, User.UserRole.ADMIN);
    }
    @Override
    public User updateAdmin(Long id, UserRequestDTO userRequestDTO) {
        User user = getAdminById(id); // Ensure the user exists and is an admin
        updateUserFields(user, userRequestDTO);
        return userRepository.save(user);
    }
    @Override
    public void deleteAdmin(Long id) {
        User user = getAdminById(id);
        userRepository.delete(user);
    }
    public User createAdmin(UserRequestDTO userRequestDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setEmail(userRequestDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));  // Encrypt password
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(User.UserRole.ADMIN);  // Default to DRIVER role
        user.setStatus(User.UserStatus.ACTIVE);  // Default to ACTIVE status

        // Save and return the cus
        return userRepository.save(user);


    }

    public void updateUserFields(User user, UserRequestDTO dto) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setContactNumber(dto.getContactNumber());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        // Add more fields as necessary
    }
}
