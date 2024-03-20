package com.epicode.capstone.Capstone.Backend.dao;

import com.epicode.capstone.Capstone.Backend.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
