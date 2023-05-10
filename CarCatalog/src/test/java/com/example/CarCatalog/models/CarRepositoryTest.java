package com.example.CarCatalog.models;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CarCatalog.repositories.CarRepository;

@SpringBootTest
public class CarRepositoryTest {
    
    @Autowired
    private CarRepository repository;

    @Test
    public void test() {
        List<Car> cars = repository.findAll();
		for (Car car : cars) {
            System.out.println(" ASDSA DAS DASD ASD ASD ASD ASDSAD AD ASD ");
			System.out.println(car.getModelId().getName() + " " + car.getVin_number());
		}
    }
}
