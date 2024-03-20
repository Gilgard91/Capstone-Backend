package com.epicode.capstone.Capstone.Backend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private double totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDate dateCreated;
    @UpdateTimestamp
    private LocalDate lastUpdated;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addItems(List<OrderItem> items) {
        if (items != null) {
            if (orderItems == null) {
                orderItems = new ArrayList<>();
            }
            orderItems.addAll(items);
            for (OrderItem item : items) {
                item.setOrder(this);
            }
        }
    }
}
