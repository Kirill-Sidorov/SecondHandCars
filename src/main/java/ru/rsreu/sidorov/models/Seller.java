package ru.rsreu.sidorov.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author Fact S Musingarimi
 * 5/13/19
 * 1:00 PM
 */
@Data
public class Seller implements UserDetails {

    private long id;
    /*
    //@NotNull
    //@Size(min=5, message="Name must be at least 5 characters long")
    @NotBlank(message="Необходимо заполнить город")
    private String city;
    //@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
    //        message="Must be formatted MM/YY")
    @NotBlank(message="Необходимо заполнить имя владельца")
    private String nameOwner;
    //@Digits(integer=3, fraction=0, message="Invalid CVV")
    @NotBlank(message="Необходимо заполнить номер телефона")
    @Pattern(regexp="^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message="Значение не соответсвует номеру телефона")
    private String phoneNumber;
    @Pattern(regexp="^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$",
            message="Значение не соответсвует email")
    private String email;
    */

    private String city;
    private String username;
    private String phoneNumber;
    private String email;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
