package com.example.garbagecollection.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bins")
public class Bin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime lastUpdated;

    public void setLatitude(@NotNull double latitude) {
    }

    public void setLongitude(@NotNull double longitude) {
    }

    public void setStatus(Status status) {
    }

    public void setLastUpdated(LocalDateTime now) {
    }

    public double getLatitude() {
        return 0;
    }

    public double getLongitude() {
        return 0;
    }

    public enum Status {
        FULL, EMPTY
    }

}
