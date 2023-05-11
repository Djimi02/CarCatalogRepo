package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.FuelType;
import java.util.List;


@Repository
public interface FuelTypeRepository extends JpaRepository<FuelType, Long> {
    List<FuelType> findByName(String name);
}
