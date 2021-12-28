package com.example.petshop;

import com.example.petshop.models.Product;
import com.example.petshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        if (productsRepository.count() == 0) {
            Product prod1 = new Product();
            Product prod2 = new Product();
            prod1.setName("Product 1");
            prod2.setName("Product 2");
            productsRepository.save(prod1);
            productsRepository.save(prod2);
        }
        System.out.println(productsRepository.count());
    }
}