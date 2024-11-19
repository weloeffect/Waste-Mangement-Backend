package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.VehicleRequestDto;
import com.example.garbagecollection.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    VehicleRequestDto createVehicle(VehicleRequestDto vehicleDto);

    VehicleRequestDto getVehicleById(Long id);

    List<VehicleRequestDto> getAllVehicles();

    VehicleRequestDto updateVehicle(Long id, VehicleRequestDto vehicleDto);

    void deleteVehicle(Long id);
}
