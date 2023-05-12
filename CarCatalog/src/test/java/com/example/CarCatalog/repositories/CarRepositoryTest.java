package com.example.CarCatalog.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CarCatalog.models.Car;

/* The class uses the data from the bean in CarCatalogApplication. */
@SpringBootTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Test
    public void test1() {
        List<Car> cars = repository.filter("q5", null, null, null, null, null);
        int expectedSize = 1;
        assertEquals(expectedSize, cars.size());
    }

    @Test
    public void test2() {
        List<Car> cars = repository.filter(null, "audi", null, null, null, null);
        int expectedSize = 2;
        assertEquals(expectedSize, cars.size());
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void test3() {
        List<Car> cars = repository.filter("passat", "audi", null, null, null, null);
        int expectedSize = 0;
        assertEquals(expectedSize, cars.size());
    }

    @Test
    public void test4() {
        List<Car> cars = repository.filter(null, null, null, null, 30000, null);
        int expectedSize = 4;
        assertEquals(expectedSize, cars.size());
        for (int i = 0; i < cars.size() - 1; i++) {
            assertTrue(cars.get(i).getPrice() >= cars.get(i + 1).getPrice());
        }
    }

    @Test
    public void test5() {
        List<Car> cars = repository.filter(null, null, "gas", null, null, null);
        int expectedSize = 2;
        assertEquals(expectedSize, cars.size());
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void test6() {
        List<Car> cars = repository.filter(null, null, null, "hybrid", null, null);
        int expectedSize = 2;
        assertEquals(expectedSize, cars.size());
        assertTrue(cars.get(0).getPrice() >= cars.get(1).getPrice());
    }

    @Test
    public void test7() {
        List<Car> cars = repository.filter(null, "audi", null, "automatic", null, null);
        int expectedSize = 1;
        assertEquals(expectedSize, cars.size());
    }

    @Test
    public void test8() {
        List<Car> cars = repository.filter("q5", "audi", null, "automatic", null, null);
        int expectedSize = 1;
        assertEquals(expectedSize, cars.size());
    }

    @Test
    public void test9() {
        List<Car> cars = repository.filter("q7", "audi", null, "automatic", null, null);
        int expectedSize = 0;
        assertEquals(expectedSize, cars.size());
    }

    @Test
    public void test10() {
        List<Car> cars = repository.filter("q7", null, null, null, 15000, null);
        int expectedSize = 0;
        assertEquals(expectedSize, cars.size());
    }
}
