package com.example.garbagecollection.repository;

import com.example.garbagecollection.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Driver, Long> {
}
