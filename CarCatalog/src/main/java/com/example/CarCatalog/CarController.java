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
import com.example.CarCatalog.services.CarService;

@RestController
@RequestMapping(path = "car/")
public class CarController {
    
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarService carService;

    @GetMapping(path = "allcars")
    public List<Car> allCars() {
        List<Car> cars = carRepository.test();

        for (Car car : cars) {
            System.out.println("ASD ASD ASD ASD ASDAS DASD ASD");
            System.out.println(car.getModelId().getBrandId().getName());
        }

        return null;
    }

    @GetMapping(path = "onecar")
    public Car oneCars() {
        return carRepository.test1("vin num 234");
    }

    @PostMapping(path = "add")
    public void addCar(@RequestBody Car car) {
        this.carService.saveCar(car);
    }
}
