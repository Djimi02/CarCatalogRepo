package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Transmission;
import java.util.List;


@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    List<Transmission> findByName(String name);
}
