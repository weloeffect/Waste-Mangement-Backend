package com.example.garbagecollection.service;

import com.example.garbagecollection.dto.BinRequestDTO;
import com.example.garbagecollection.entity.Bin;
import com.example.garbagecollection.repository.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BinServiceImpl implements BinService {

    @Autowired
    private BinRepository binRepository;

    @Override
    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    @Override
    public Bin createBin(BinRequestDTO binRequestDTO) {
        Bin bin = new Bin();
        bin.setLatitude(binRequestDTO.getLatitude());
        bin.setLongitude(binRequestDTO.getLongitude());
        bin.setStatus(Bin.Status.valueOf(binRequestDTO.getStatus()));
        bin.setLastUpdated(LocalDateTime.now());
        return binRepository.save(bin);
    }
}
