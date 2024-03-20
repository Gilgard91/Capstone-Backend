package com.epicode.capstone.Capstone.Backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String name;
    private String description;
    private double unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
    @CreationTimestamp
    private LocalDate dateCreated;
    @UpdateTimestamp
    private LocalDate lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    public Product(String sku, String name, String description, double unitPrice, String imageUrl,
                   boolean active, int unitsInStock, ProductCategory category) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.imageUrl = imageUrl;
        this.active = active;
        this.unitsInStock = unitsInStock;
        this.category = category;
    }
}
