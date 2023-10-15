package com.example.springsecuritydemoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringSecurityDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoAppApplication.class, args);
    }

}
