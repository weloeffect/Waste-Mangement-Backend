package com.example.garbagecollection.entity;

import com.example.garbagecollection.entity.User;
import jakarta.persistence.*;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(nullable = false)
    private String vehicleBrand;

    @Column(nullable = false, unique = true)
    private String plateNumber;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Getters and Setters
    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public User getDriver() {
        return user;
    }

    public void setDriver(User user) {
        this.user = user;
    }
}
