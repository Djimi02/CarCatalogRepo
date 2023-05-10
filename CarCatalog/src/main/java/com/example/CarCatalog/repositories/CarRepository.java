package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    
}
