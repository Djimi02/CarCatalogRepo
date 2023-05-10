package com.example.CarCatalog.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String vin_number;
    private Integer price;


    public Car(String vin_number, Integer price) {
        this.vin_number = vin_number;
        this.price = price;
    }

}
