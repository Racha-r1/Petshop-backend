package com.example.petshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class PetshopApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PetshopApplication.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "5000"));
        app.run(args);
    }

}
