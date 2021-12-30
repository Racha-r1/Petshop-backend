package com.example.petshop.repositories;

import com.example.petshop.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository  extends CrudRepository<Category, Long> {
}
