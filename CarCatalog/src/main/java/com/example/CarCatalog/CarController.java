package com.example.CarCatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CarCatalog.models.Car;
import com.example.CarCatalog.repositories.CarRepository;

@RestController
@RequestMapping(path = "car/")
public class CarController {
    
    @Autowired
    private CarRepository carRepository;

    @GetMapping(path = "allcars")
    public List<Car> allCars() {
        List<Car> cars = carRepository.test();

        for (Car car : cars) {
            System.out.println("ASD ASD ASD ASD ASDAS DASD ASD");
            System.out.println(car.getModelId().getBrandId().getName());
        }

        return cars;
    }

    @GetMapping(path = "onecars")
    public Car oneCars() {
        return carRepository.test1("vin number3");
    }

    @PostMapping(path = "add")
    public void addCar(@RequestBody Car car) {
        if(car.getTransmissionId() == null) {
            throw new IllegalArgumentException("transmission should not be null");
        }

        System.out.println(car.getRemarks());
        System.out.println(car.getModelId().getBrandId().getName());
        System.out.println(car.getFuelTypeId().getName());
        System.out.println(car.getTransmissionId().getName());
    }
}
