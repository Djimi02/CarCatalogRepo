package com.example.CarCatalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    
    @Query(value = "SELECT * FROM car", nativeQuery = true)
    List<Car> test();

    @Query(value = "SELECT * FROM car WHERE car.vin_number = ?1", nativeQuery = true)
    Car test1(String str);

    @Query(value = "SELECT remarks FROM car WHERE car.vin_number = ?1", nativeQuery = true)
    Car test2(String str);
}
