package com.epicode.capstone.Capstone.Backend.dto;

import com.epicode.capstone.Capstone.Backend.entities.ProductCategory;

public record ProductDTO(String sku, String name, String description, double unitPrice, String imageUrl,
                         boolean active, int unitsInStock, ProductCategory category) {
}
