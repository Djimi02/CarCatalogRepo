package com.example.CarCatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
