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

    @GetMapping("/new")
    public String createCarForm(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "add_car";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.saveCar(car);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editCarForm(@PathVariable Long id, Model model) {
        model.addAttribute("car", carService.getCarById(id));
        return "update_car";
    }

    @PostMapping("/{id}")
    public String updateCar(@PathVariable Long id,
                            @ModelAttribute("car") Car car,
                            Model model) {
        car.setBrand(car.getBrand());
        car.setModel(car.getModel());
        car.setYear(car.getYear());
        car.setProblem(car.getProblem());
        car.setStatus(car.getStatus());

        carService.updateCar(car);
        return "redirect:/";
    }

    @GetMapping("/deleteCar/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.carService.deleteCar(id);
        return "redirect:/";
    }

    @GetMapping("/")
    public String carList(Model model) {
        model.addAttribute("cars", carService.getAllCar());
        return "index";
    }
}
