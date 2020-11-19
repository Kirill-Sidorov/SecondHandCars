package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.rsreu.sidorov.carspecifications.*;
import ru.rsreu.sidorov.data.CarInfoRepository;
import ru.rsreu.sidorov.models.CarInfo;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/car_info")
public class CarInfoController {

    private CarInfoRepository carInfoRepository;
    private long sellerId;
    private long carId;

    @Autowired
    public CarInfoController(CarInfoRepository carInfoRepository) {
        this.carInfoRepository = carInfoRepository;
    }

    @ModelAttribute("carInfo")
    public CarInfo createCarInfo() {
        return new CarInfo();
    }

    @GetMapping
    public String showCarInfo(@ModelAttribute("sellerId") long sellerId, @ModelAttribute("carId") long carId, Model model) {
        this.sellerId = sellerId;
        this.carId = carId;
        model = fillModel(model);
        model.addAttribute("carInfo", createCarInfo());
        return "car_info";
    }

    @PostMapping
    public String processCarInfo (@Valid @ModelAttribute("carInfo") CarInfo carInfo, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model = fillModel(model);
            return "car_info";
        }
        carInfo.setCarId(carId);
        carInfo.setSellerId(sellerId);
        carInfoRepository.save(carInfo);
        log.info("Processing: " + carInfo);
        return "redirect:/";
    }

    private Model fillModel(Model model) {
        TypeBody[] typeBodyArray = TypeBody.values();
        TypeFuel[] typeFuelArray = TypeFuel.values();
        TypeTransmission[] typeTransmissionArray = TypeTransmission.values();
        TypeDrive[] typeDriveArray = TypeDrive.values();
        PassportVehicle[] passportVehicles = PassportVehicle.values();
        Owner[] owners = Owner.values();
        model.addAttribute("typeBodyArray", typeBodyArray);
        model.addAttribute("typeFuelArray", typeFuelArray);
        model.addAttribute("typeTransmissionArray", typeTransmissionArray);
        model.addAttribute("typeDriveArray", typeDriveArray);
        model.addAttribute("passportVehicles", passportVehicles);
        model.addAttribute("owners", owners);
        return model;
    }

}
