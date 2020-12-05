package ru.rsreu.sidorov.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.rsreu.sidorov.data.SellerRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private SellerRepository sellerRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(
            SellerRepository sellerRepository, PasswordEncoder passwordEncoder) {
        this.sellerRepository = sellerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        sellerRepository.save(form.toSeller(passwordEncoder));
        return "redirect:/seller_info";
    }

}
