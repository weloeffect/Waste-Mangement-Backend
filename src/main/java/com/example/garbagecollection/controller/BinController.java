package com.example.garbagecollection.controller;

import com.example.garbagecollection.dto.BinRequestDTO;
import com.example.garbagecollection.entity.Bin;
import com.example.garbagecollection.service.BinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bins")
public class BinController {

    @Autowired
    private BinService binService;

    @GetMapping
    public ResponseEntity<List<Bin>> getAllBins() {
        return ResponseEntity.ok(binService.getAllBins());
    }

    @PostMapping
    public ResponseEntity<Bin> createBin(@RequestBody BinRequestDTO binRequestDTO) {
        return ResponseEntity.ok(binService.createBin(binRequestDTO));
    }
}
