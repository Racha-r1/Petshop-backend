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

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('update:products')")
    public Product updateProduct(@PathVariable long id,@RequestBody Product productData){
        Optional<Product> product = productsRepository.findById(id);
        if (product.isPresent()){
            Product updatedProduct = product.get();
            updatedProduct.setName(productData.getName());
            updatedProduct.setPrice(productData.getPrice());
            updatedProduct.setImage(productData.getImage());
            updatedProduct.setDescription(productData.getDescription());
            updatedProduct.setCategory(productData.getCategory());
            updatedProduct.setPet(productData.getPet());
            return productsRepository.save(updatedProduct);
        }
        // if nothing is updated just return the requestbody data
        return productData;
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('delete:products')")
    public void deleteProduct(@PathVariable long id){
        productsRepository.deleteById(id);
    }

}
