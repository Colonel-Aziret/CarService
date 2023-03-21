package com.example.carservice.service;

import com.example.carservice.entity.Car;
import com.example.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public void saveCar(Car car) {
        this.carRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        this.carRepository.deleteById(id);
    }

    @Override
    public List<Car> getAllCar() {
        return carRepository.findAll();
    }
}
