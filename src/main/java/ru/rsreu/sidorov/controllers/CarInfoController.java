package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rsreu.sidorov.carspecifications.*;
import ru.rsreu.sidorov.data.CarInfoRepository;
import ru.rsreu.sidorov.models.CarInfo;
import ru.rsreu.sidorov.models.Seller;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/car_info")
public class CarInfoController {

    private CarInfoRepository carInfoRepository;
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
    public String showCarInfo(@ModelAttribute("carId") long carId, Model model) {
        model = fillModel(model);
        this.carId = carId;
        model.addAttribute("carInfo", createCarInfo());
        return "car_info";
    }

    @PostMapping
    public String processCarInfo (@Valid @ModelAttribute("carInfo") CarInfo carInfo, Errors errors, Model model, final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            model = fillModel(model);
            return "car_info";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Seller seller = (Seller) authentication.getPrincipal();
        carInfo.setSellerId(seller.getId());
        carInfo.setCarId(carId);
        redirectAttributes.addFlashAttribute("carInfo", carInfo);
        carInfoRepository.save(carInfo);
        log.info("Processing: " + carInfo);
        return "redirect:/ad";
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
