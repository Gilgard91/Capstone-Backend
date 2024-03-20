package com.epicode.capstone.Capstone.Backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country")
    private List<Region> regions;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
