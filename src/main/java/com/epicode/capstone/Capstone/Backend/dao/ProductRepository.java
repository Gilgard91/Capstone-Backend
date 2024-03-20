package com.epicode.capstone.Capstone.Backend.dao;

import com.epicode.capstone.Capstone.Backend.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findByCategoryId(@Param("id") Long id);
//    List<Product> findByNameContainingIgnoreCase(@Param("name") String name);

    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
    Page<Product> findByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    List<Product>findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryCategoryNameIgnoreCase(String categoryName);
}
