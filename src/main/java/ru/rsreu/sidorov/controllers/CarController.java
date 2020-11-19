package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rsreu.sidorov.data.CarRepository;
import ru.rsreu.sidorov.models.Car;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/car")
@SessionAttributes("car")
public class CarController {

    private CarRepository carRepository;
    private long sellerId;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @ModelAttribute("car")
    public Car createCar() {
        return new Car();
    }

    @GetMapping("/car_brands")
    public ModelAndView showCarBrands(@ModelAttribute("sellerId") long sellerId) {
        this.sellerId = sellerId;
        ModelAndView modelAndView = new ModelAndView();
        List<String> carsBrands = new ArrayList<>();
        carRepository.findAllBrands().forEach(i -> carsBrands.add(i));
        modelAndView.addObject("carBrands", carsBrands);
        modelAndView.addObject("car", createCar());
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
        carRepository.findAllModels(car.getBrand()).forEach(i -> carModels.add(i));
        modelAndView.addObject("carModels", carModels);
        modelAndView.addObject("car", car);
        modelAndView.setViewName("car_models");
        return modelAndView;
    }

    @PostMapping("/car_models")
    public String processCarModels(@ModelAttribute("car") Car car, SessionStatus sessionStatus, final RedirectAttributes redirectAttributes) {
        sessionStatus.setComplete();
        long carId = carRepository.findCarIdByModel(car.getModel());
        redirectAttributes.addFlashAttribute("sellerId", sellerId);
        redirectAttributes.addFlashAttribute("carId", carId);
        return "redirect:/car_info";
    }
    /*
    @ModelAttribute("car")
    public Car createUser() {
        return new Car();
    }

    @GetMapping("/car_brands")
    public ModelAndView showCarBrands(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        CarBrandEnum[] carBrandEnums = CarBrandEnum.values();
        modelAndView.addObject("carBrands", carBrandEnums);
        modelAndView.addObject("car", new Car());
        modelAndView.setViewName("car_brands");
        return modelAndView;
    }

    @GetMapping("/car_models")
    public ModelAndView showCarModels(@ModelAttribute("car") Car car) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("car", car);
        modelAndView.setViewName("car_models");
        return modelAndView;
    }

    @PostMapping("/car_brands")
    public String processCarBrands(@ModelAttribute("car") Car cars) {
        return "redirect:/car/car_models";
    }

    @PostMapping("/car_models")
    public String processCarModels(@ModelAttribute("car") Car car, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/car_info";
    }
    */
}
