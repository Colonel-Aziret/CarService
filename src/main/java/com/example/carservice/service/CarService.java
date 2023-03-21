package com.example.carservice.service;

import com.example.carservice.entity.Car;

import java.util.List;

public interface CarService {
    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(long id);

    List<Car> getAllCar();
}
