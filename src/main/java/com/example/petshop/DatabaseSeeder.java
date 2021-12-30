package com.example.petshop;

import com.example.petshop.models.Category;
import com.example.petshop.models.Pet;
import com.example.petshop.models.Product;
import com.example.petshop.repositories.CategoryRepository;
import com.example.petshop.repositories.PetsRepository;
import com.example.petshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private PetsRepository petsRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {

        Category category1 = new Category();
        category1.setName("Voeding");
        Category category2 = new Category();
        category2.setName("Kooien");
        Pet pet = new Pet();
        pet.setName("Kat");
        pet.setCategories(Arrays.asList(category1, category2));
        Pet pet2 = new Pet();
        pet2.setName("Hond");
        pet2.setCategories(Arrays.asList(category1, category2));
        Product prod1 = new Product();
        Product prod2 = new Product();
        prod1.setName("Product 1");
        prod2.setName("Product 2");
        prod1.setCategory(category1);
        prod1.setPet(pet);
        prod2.setCategory(category1);
        prod2.setPet(pet2);

        if (categoryRepository.count() == 0) {
            categoryRepository.save(category1);
            categoryRepository.save(category2);
        }

        if (petsRepository.count() == 0) {
            petsRepository.save(pet);
            petsRepository.save(pet2);
        }

        if (productsRepository.count() == 0) {
            productsRepository.save(prod1);
            productsRepository.save(prod2);
        }
    }
}