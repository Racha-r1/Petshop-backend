package com.example.petshop.controllers;

import com.example.petshop.models.Pet;
import com.example.petshop.repositories.PetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("{id}")
    public Optional<Pet> getPet(@PathVariable long id){
        return petsRepository.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:pets')")
    public Pet addPet(@RequestBody Pet pet){
        return petsRepository.save(pet);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('update:products')")
    public Pet updatePet(@PathVariable long id,@RequestBody Pet petData){
        Optional<Pet> pet = petsRepository.findById(id);
        if (pet.isPresent()){
            Pet updatedPet = pet.get();
            updatedPet.setName(petData.getName());
            return petsRepository.save(updatedPet);
        }
        // if nothing is updated just return the requestbody data
        return petData;
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('delete:pets')")
    public void deletePet(@PathVariable long id){
        petsRepository.deleteById(id);
    }

}
