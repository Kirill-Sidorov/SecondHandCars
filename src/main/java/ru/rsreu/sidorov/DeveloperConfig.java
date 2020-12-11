package ru.rsreu.sidorov;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")
@Configuration
public class DeveloperConfig {
    @PostConstruct
    public void message() {
        System.out.println("Developer Config");
    }
}