package ru.rsreu.sidorov.security;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.rsreu.sidorov.models.Seller;

@Data
public class RegistrationForm {

    private String city;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;

    public Seller toSeller(PasswordEncoder passwordEncoder) {
        Seller seller = new Seller();
        seller.setCity(city);
        seller.setUsername(username);
        seller.setPhoneNumber(phoneNumber);
        seller.setEmail(email);
        seller.setPassword(passwordEncoder.encode(password));
        return seller;
    }
}
