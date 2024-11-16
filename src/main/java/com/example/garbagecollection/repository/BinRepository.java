package com.example.garbagecollection.repository;

import com.example.garbagecollection.entity.Bin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinRepository extends JpaRepository<Bin, Long> {
}
