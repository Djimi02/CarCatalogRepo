package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.FuelType;

@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    
}
