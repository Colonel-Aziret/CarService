package com.example.carservice.controller;

import com.example.carservice.entity.Car;
import com.example.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/addCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.saveCar(car);
        return "redirect:/";
    }

    @PostMapping("/updateCar/{id}")
    public String updateCar(@PathVariable Long id,
                            @ModelAttribute("car") Car car,
                            Model model) {
        Car carDetails = new Car();
        carDetails.setId(id);
        carDetails.setBrand(car.getBrand());
        carDetails.setModel(car.getModel());
        carDetails.setYear(car.getYear());

        carService.updateCar(car);
        return "redirect:/";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.carService.deleteCar(id);
        return "redirect:/";
    }

    @GetMapping("/carList")
    public String carList(Model model) {
        model.addAttribute("car", carService.getAllCar());
        return "main";
    }
}
