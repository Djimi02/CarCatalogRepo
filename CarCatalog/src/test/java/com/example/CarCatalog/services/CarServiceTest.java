package com.example.CarCatalog.services;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CarCatalog.models.Brand;
import com.example.CarCatalog.models.Car;
import com.example.CarCatalog.models.FuelType;
import com.example.CarCatalog.models.Model;
import com.example.CarCatalog.models.Transmission;

@SpringBootTest
public class CarServiceTest {
    
    @Autowired
    private CarService carService = new CarService();

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest1() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 10000, new Date(), null, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest2() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, null, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest3() {
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", null, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest4() {
        Model q5 = new Model("q5", null);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest5() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, null, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest6() {
        Brand vw = new Brand(null);
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest7() {
        Brand vw = new Brand("");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest8() {
        Brand vw = new Brand("vw");
        Model q5 = new Model(null, vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest9() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest10() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission(null);
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest11() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest12() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType(null);
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest13() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("");
        Car car1 = new Car("vin number", q5, 13, new Date(), hybrid, gas, "new");
        carService.saveCar(car1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkMandatoryFieldsTest14() {
        Brand vw = new Brand("vw");
        Model q5 = new Model("q5", vw);
        Transmission hybrid = new Transmission("hybrid");
        FuelType gas = new FuelType("gas");
        Car car1 = new Car("vin number", q5, 13, null, hybrid, gas, "new");
        carService.saveCar(car1);
    }
}
