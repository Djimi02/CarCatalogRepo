package com.example.CarCatalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(path = "all")
    public List<Car> allCars() {
        List<Car> cars = carRepository.findAll();

        for (Car car : cars) {
            System.out.println("ASD ASD ASD ASD ASDAS DASD ASD");
            System.out.println(car.getModelId().getBrandId().getName());
        }

        return null;
    }

    @GetMapping(path = "sort")
    public List<Car> sortCars(@RequestParam(required = false, name = "fuel_type") String fuelType,
        @RequestParam(required = false, name = "model") String model, 
        @RequestParam(required = false, name = "brand") String brand,
        @RequestParam(required = false, name = "tran_type") String tranType,
        @RequestParam(required = false, name = "price") Integer price) {

        List<Car> cars = carRepository.testSort(model, brand, fuelType, tranType, price);

        System.out.println("SORTED:");

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println(car.getRemarks() + " " + car.getModelId().getBrandId().getName() + " " +
            car.getPrice() + " " + car.getModelId().getName() + " " + car.getVin_number() + " " + 
            car.getFuelTypeId().getName() + " " + car.getTransmissionId().getName());
        }

        return null;
    }

    @PostMapping(path = "add")
    public void addCar(@RequestBody Car car) {
        this.carService.saveCar(car);
    }
}
