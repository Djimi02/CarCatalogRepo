package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    
}