package com.epicode.capstone.Capstone.Backend.dao;

import com.epicode.capstone.Capstone.Backend.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    List<Region> findByCountryCodeIgnoreCase(String code);
}
