package com.example.petshop.repositories;

import com.example.petshop.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetsRepository extends CrudRepository<Pet, Long> {
}
