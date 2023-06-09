package com.example.CarCatalog;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return carRepository.findAll();
    }

    @GetMapping(path = "sort")
    public List<Car> sortCars(@RequestParam(required = false, name = "fuel_type") String fuelType,
        @RequestParam(required = false, name = "model") String model, 
        @RequestParam(required = false, name = "brand") String brand,
        @RequestParam(required = false, name = "tran_type") String tranType,
        @RequestParam(required = false, name = "price") Integer price,
        @RequestParam(required = false, name = "reg_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date regDate) {

        return carRepository.filter(model, brand, fuelType, tranType, price, regDate);

    }

    @PostMapping(path = "add")
    public void addCar(@RequestBody Car car) {
        this.carService.saveCar(car);
    }

    @DeleteMapping(path = "delete")
    public void deleteCar(@RequestParam(name = "id") Long id) {
        this.carService.deleteCar(id);
    }

    @PutMapping(path = "update")
    public void updateCar(@RequestParam(name = "id") Long id, @RequestBody Car car) {
        this.carService.updateCar(id, car);
    }
}
