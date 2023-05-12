package com.example.CarCatalog.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT c.id, c.price, c.reg_date, c.remarks, c.vin_number, c.fuel_type_id, c.model_id, c.transmission_id " + 
                    "FROM car c, model m, brand b, fuel_type ft, transmission t " + 
                    "WHERE c.model_id = m.id AND m.brand_id = b.id AND c.fuel_type_id = ft.id AND c.transmission_id = t.id AND " + 
                    "(m.name = :model OR :model is null) AND " + 
                    "(b.name = :brand OR :brand is null) AND " + 
                    "(ft.name = :fuelType OR :fuelType is null) AND " +
                    "(t.name = :tranType OR :tranType is null) AND " + 
                    "(c.price <= :price OR :price is null) AND " +
                    "(c.reg_date = :regDate OR (cast(:regDate as date) is null)) " +
                    "ORDER BY c.price DESC", nativeQuery = true)
    List<Car> filter(String model, String brand, String fuelType, String tranType, Integer price, Date regDate);
}
