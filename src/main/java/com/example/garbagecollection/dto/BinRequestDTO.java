package com.example.garbagecollection.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BinRequestDTO {

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    @NotNull
    private String status;
}
