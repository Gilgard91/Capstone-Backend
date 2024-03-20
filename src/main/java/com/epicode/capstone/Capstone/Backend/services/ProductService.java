package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.ProductRepository;
import com.epicode.capstone.Capstone.Backend.dto.ProductDTO;
import com.epicode.capstone.Capstone.Backend.entities.Product;
import com.epicode.capstone.Capstone.Backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Page<Product> getProducts(int pageNumber, int size, String orderBy){
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(pageNumber, size, Sort.by(orderBy));
        return this.productRepository.findAll(pageable);
    }

    public List<Product> getProductsList(){
        return this.productRepository.findAll();
    }

    public Product findById(Long productId){
        return this.productRepository.findById(productId).orElseThrow(()-> new NotFoundException(productId));
    }

    public Product saveProduct(ProductDTO body){
        Product product = new Product(body.sku(),body.name(),body.description(),body.unitPrice(),body.imageUrl(),
                body.active(),body.unitsInStock(),body.category());

        return productRepository.save(product);
    }

    public void findByIdAndDelete(Long id){
        Product product = this.findById(id);
        productRepository.delete(product);
    }
    public Product findByIdAndUpdate(Long productId, Product updatedProduct){
        Product product = findById(productId);
        product.setSku(updatedProduct.getSku());
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setUnitPrice(updatedProduct.getUnitPrice());
        product.setImageUrl(updatedProduct.getImageUrl());
        product.setActive(updatedProduct.isActive());
        product.setUnitsInStock(updatedProduct.getUnitsInStock());
        product.setCategory(updatedProduct.getCategory());

        return this.productRepository.save(product);
    }

    public Page<Product> findByCategory(Long id, Pageable pageable){
        return productRepository.findByCategoryId(id, pageable);
    }

    public Page<Product> findByName(String name, Pageable pageable){
        return productRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public List<Product> findByNameList(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> findByCategory(String categoryName){
        return productRepository.findByCategoryCategoryNameIgnoreCase(categoryName);
    }
}
