package com.epicode.capstone.Capstone.Backend.controllers;

import com.epicode.capstone.Capstone.Backend.dto.CountryDTO;
import com.epicode.capstone.Capstone.Backend.entities.Country;
import com.epicode.capstone.Capstone.Backend.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return this.countryService.getCountriesList();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Country saveCountry(@RequestBody CountryDTO country){
        return this.countryService.saveCountry(country);
    }
}
