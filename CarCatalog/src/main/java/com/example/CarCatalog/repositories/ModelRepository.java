package com.example.CarCatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarCatalog.models.Model;
import java.util.List;


@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    
    List<Model> findByName(String name);

}
