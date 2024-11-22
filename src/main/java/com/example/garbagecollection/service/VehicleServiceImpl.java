package com.example.garbagecollection.service;
import com.example.garbagecollection.dto.VehicleRequestDto;
import com.example.garbagecollection.entity.User;
import com.example.garbagecollection.entity.Vehicle;
import com.example.garbagecollection.repository.UserRepository;
import com.example.garbagecollection.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public VehicleRequestDto createVehicle(VehicleRequestDto vehicleDto) {
        User user = userRepository.findById(vehicleDto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleBrand(vehicleDto.getVehicleBrand());
        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setDriver(user);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return mapToDto(savedVehicle);
    }

    @Override
    public VehicleRequestDto getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return mapToDto(vehicle);
    }

    @Override
    public List<VehicleRequestDto> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleRequestDto updateVehicle(Long id, VehicleRequestDto vehicleDto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        User user = userRepository.findById(vehicleDto.getDriverId())
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        vehicle.setVehicleBrand(vehicleDto.getVehicleBrand());
        vehicle.setPlateNumber(vehicleDto.getPlateNumber());
        vehicle.setDriver(user);

        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return mapToDto(updatedVehicle);
    }

    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicleRepository.delete(vehicle);
    }

    private VehicleRequestDto mapToDto(Vehicle vehicle) {
        VehicleRequestDto dto = new VehicleRequestDto();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setVehicleBrand(vehicle.getVehicleBrand());
        dto.setPlateNumber(vehicle.getPlateNumber());
        dto.setDriverId(vehicle.getDriver().getId());
        return dto;
    }
}
