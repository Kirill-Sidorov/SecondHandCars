package ru.rsreu.sidorov.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.rsreu.sidorov.data.SellerRepository;
import ru.rsreu.sidorov.models.Seller;

@Service
public class SellerRepositoryUserDetailsService implements UserDetailsService {


    private SellerRepository sellerRepository;

    @Autowired
    public SellerRepositoryUserDetailsService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Seller seller = sellerRepository.findByUsername(username);
        if (seller != null) {
            return seller;
        }
        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
