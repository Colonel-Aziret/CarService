package com.example.carservice.service;

import com.example.carservice.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(long id);
    Optional<Car> getCarById(Long id);

    List<Car> getAllCar();
}
