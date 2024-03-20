package com.epicode.capstone.Capstone.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public void add(Order order){
        if(order != null){
            if(orders == null){
                orders = new ArrayList<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
}
