package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.CountryRepository;
import com.epicode.capstone.Capstone.Backend.dto.CountryDTO;
import com.epicode.capstone.Capstone.Backend.entities.Country;
import com.epicode.capstone.Capstone.Backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getCountriesList(){
        return this.countryRepository.findAll();
    }

    public Country findById(Long id){
        return this.countryRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public Country saveCountry(CountryDTO body){
        Country country = new Country(body.code(), body.name());

        return countryRepository.save(country);
    }


}
