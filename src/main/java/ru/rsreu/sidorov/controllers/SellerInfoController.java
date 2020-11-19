package ru.rsreu.sidorov.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.rsreu.sidorov.data.SellerRepository;
import ru.rsreu.sidorov.models.Seller;

import javax.validation.Valid;

/**
 * @author Fact S Musingarimi
 * 5/13/19
 * 12:50 PM
 */
@Slf4j
@Controller
@RequestMapping("/seller_info")
public class SellerInfoController {

    private SellerRepository sellerRepository;

    @Autowired
    public SellerInfoController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @ModelAttribute("seller")
    public Seller createSeller() {
        return new Seller();
    }

    @GetMapping
    public String sellerInfoForm(Model model) {
        model.addAttribute("seller", createSeller());
        return "seller_info";
    }

    @PostMapping
    public String processSellerInfo(@Valid @ModelAttribute("seller") Seller seller, Errors errors, Model model, final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "seller_info";
        }
        seller = sellerRepository.save(seller);
        long sellerId = seller.getId();
        redirectAttributes.addFlashAttribute("sellerId", sellerId);
        log.info("Processing: " + seller);
        return "redirect:/car/car_brands";
    }
}
