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
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String region;
    private String country;
    private String zipCode;

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
