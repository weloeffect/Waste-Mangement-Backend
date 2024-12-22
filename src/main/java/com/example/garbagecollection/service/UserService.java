package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.UserRequestDTO;
import com.example.garbagecollection.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllDrivers();
    User createDriver(UserRequestDTO userRequestDTO);
    User getDriverById(Long userId);
    List<User> getDriversByName(String name);
    User updateDriver(Long id, UserRequestDTO userRequestDTO);
    void deleteDriver(Long id);

    List<User> getAllCustomers();
    User getCustomerById(Long userId);
    List<User> getCustomersByName(String name);
    User updateCustomer(Long id, UserRequestDTO userRequestDTO);
    User createCustomer(UserRequestDTO userRequestDTO);
    void deleteCustomer(Long id);

    List<User> getAllAdmins();
    User getAdminById(Long userId);
    List<User> getAdminsByName(String name);
    User updateAdmin(Long id, UserRequestDTO userRequestDTO);
    User createAdmin(UserRequestDTO userRequestDTO);
    void deleteAdmin(Long id);

    void updateUserFields(User user, UserRequestDTO dto);


}
