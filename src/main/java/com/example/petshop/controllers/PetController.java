package com.example.petshop.controllers;

import com.example.petshop.models.Pet;
import com.example.petshop.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pets")
@CrossOrigin(origins = "http://localhost:3000")
public class PetController {

    @Autowired
    private PetsRepository petsRepository;

    @GetMapping
    public Iterable<Pet> getAllPets(){
        return petsRepository.findAll();
    }
}
