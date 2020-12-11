package ru.rsreu.sidorov;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.rsreu.sidorov.data.CarRepository;

@SpringBootApplication
public class SecondHandCarApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandCarApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login");
    }

}
