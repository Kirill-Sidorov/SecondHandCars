package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rsreu.sidorov.data.CarRepository;
import ru.rsreu.sidorov.models.Car;
import ru.rsreu.sidorov.models.Seller;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/car")
@SessionAttributes("car")
public class CarController {

    private CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/car_brands")
    public ModelAndView showCarBrands() {
        ModelAndView modelAndView = new ModelAndView();
        List<String> carsBrands = new ArrayList<>();
        carRepository.findAllBrands().forEach(carsBrands::add);
        modelAndView.addObject("carBrands", carsBrands);
        modelAndView.addObject("car", new Car());
        modelAndView.setViewName("car_brands");
        return modelAndView;
    }

    @PostMapping("/car_brands")
    public String processCarBrands(@ModelAttribute("car") Car car) {
        return "redirect:/car/car_models";
    }

    @GetMapping("/car_models")
    public ModelAndView showCarModels(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        List<String> carModels = new ArrayList<>();
        carRepository.findAllModels(car.getBrand()).forEach(carModels::add);
        modelAndView.addObject("carModels", carModels);
        modelAndView.addObject("car", car);
        modelAndView.setViewName("car_models");
        return modelAndView;
    }

    @PostMapping("/car_models")
    public String processCarModels(@ModelAttribute("car") Car car, SessionStatus sessionStatus, final RedirectAttributes redirectAttributes) {
        sessionStatus.setComplete();
        long carId = carRepository.findCarIdByModel(car.getModel());
        redirectAttributes.addFlashAttribute("carId", carId);
        return "redirect:/car_info";
    }
}