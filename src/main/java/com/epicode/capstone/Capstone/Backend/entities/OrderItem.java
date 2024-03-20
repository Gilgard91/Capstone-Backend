package com.epicode.capstone.Capstone.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageUrl;
    private double unitPrice;
    private int quantity;
    private Long productId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
