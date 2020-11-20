package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.sidorov.data.CarRepository;
import ru.rsreu.sidorov.data.SellerRepository;
import ru.rsreu.sidorov.models.Car;
import ru.rsreu.sidorov.models.CarInfo;
import ru.rsreu.sidorov.models.Seller;

@Slf4j
@Controller
@RequestMapping("/ad")
public class AdController {

    private SellerRepository sellerRepository;
    private CarRepository carRepository;

    @Autowired
    public AdController(SellerRepository sellerRepository, CarRepository carRepository) {
        this.sellerRepository = sellerRepository;
        this.carRepository = carRepository;
    }

    @GetMapping
    public String showAd(@ModelAttribute("carInfo") CarInfo carInfo, Model model) {
        long sellerId = carInfo.getSellerId();
        long carId = carInfo.getCarId();
        Seller seller = sellerRepository.findById(sellerId);
        Car car = carRepository.findCarById(carId);

        model.addAttribute("carInfo", carInfo);
        model.addAttribute("seller", seller);
        model.addAttribute("car", car);

        return "ad";
    }
}
