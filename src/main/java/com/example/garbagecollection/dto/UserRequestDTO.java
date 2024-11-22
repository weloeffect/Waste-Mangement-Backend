package com.example.garbagecollection.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String contactNumber;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    private String assignedVehicle;  // Optional field for vehicle assignment
}
