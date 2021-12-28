package com.example.petshop.controllers;


import com.example.petshop.models.Product;
import com.example.petshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductsController {

    @Autowired
    ProductsRepository productsRepository;

    @GetMapping
    public Iterable<Product> getProducts(){
        return productsRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Product> getProduct(@PathVariable long id){
        return productsRepository.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:products')")
    public Product addProduct(@RequestBody Product product){
       return productsRepository.save(product);
    }

}
