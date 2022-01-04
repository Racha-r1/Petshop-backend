package com.example.petshop.controllers;

import com.example.petshop.models.Category;
import com.example.petshop.models.Pet;
import com.example.petshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public Iterable<Category> getAllCategories(){
        return categoryRepository.findAll();
    }


    @GetMapping("{id}")
    public Optional<Category> getCategory(@PathVariable long id){
        return categoryRepository.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create:categories')")
    public Category addCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('update:categories')")
    public Category updateCategory(@PathVariable long id,@RequestBody Category categoryData){
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()){
            Category updatedCategory = category.get();
            updatedCategory.setName(categoryData.getName());
            return categoryRepository.save(updatedCategory);
        }
        // if nothing is updated just return the requestbody data
        return categoryData;
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('delete:categories')")
    public void deleteCategory(@PathVariable long id){
        categoryRepository.deleteById(id);
    }

}
