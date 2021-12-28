package com.example.petshop.repositories;

import com.example.petshop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Product, Long> {

}
