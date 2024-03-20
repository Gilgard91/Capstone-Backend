package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.ProductCategoryRepository;
import com.epicode.capstone.Capstone.Backend.dto.ProductCategoryDTO;
import com.epicode.capstone.Capstone.Backend.entities.ProductCategory;
import com.epicode.capstone.Capstone.Backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    public List<ProductCategory> getCategories(){
        return this.productCategoryRepository.findAll();
    }

    public ProductCategory findById(Long categoryId){
        return this.productCategoryRepository.findById(categoryId).orElseThrow(()-> new NotFoundException(categoryId));
    }

    public ProductCategory saveCategory(ProductCategoryDTO body){
        ProductCategory category = new ProductCategory(body.categoryName());

        return productCategoryRepository.save(category);
    }

    public ProductCategory findByIdAndUpdate(Long id, ProductCategory body){
        ProductCategory productCategory = findById(id);
        productCategory.setCategoryName(body.getCategoryName());
        return this.productCategoryRepository.save(productCategory);
    }
}
