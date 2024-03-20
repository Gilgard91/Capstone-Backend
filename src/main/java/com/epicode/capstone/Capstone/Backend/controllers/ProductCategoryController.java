package com.epicode.capstone.Capstone.Backend.controllers;

import com.epicode.capstone.Capstone.Backend.dto.ProductCategoryDTO;
import com.epicode.capstone.Capstone.Backend.entities.ProductCategory;
import com.epicode.capstone.Capstone.Backend.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAllCategories(){
        return this.productCategoryService.getCategories();
    }

    @GetMapping("/{id}")
    public ProductCategory findById(@PathVariable Long id){
        return this.productCategoryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductCategory saveCategory(@RequestBody ProductCategoryDTO newCategory){
        return this.productCategoryService.saveCategory(newCategory);
    }

    @PutMapping("/{id}")
    public ProductCategory findByIdAndUpdate(@PathVariable Long id, @RequestBody ProductCategory updatedCategory){
        return this.productCategoryService.findByIdAndUpdate(id, updatedCategory);
    }
}
