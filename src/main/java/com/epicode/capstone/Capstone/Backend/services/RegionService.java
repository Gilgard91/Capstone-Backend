package com.epicode.capstone.Capstone.Backend.services;

import com.epicode.capstone.Capstone.Backend.dao.RegionRepository;
import com.epicode.capstone.Capstone.Backend.dto.RegionDTO;
import com.epicode.capstone.Capstone.Backend.entities.Region;
import com.epicode.capstone.Capstone.Backend.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    public List<Region> getRegionsList(){
        return this.regionRepository.findAll();
    }

    public Region findById(Long id){
        return this.regionRepository.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public Region saveRegion(RegionDTO body){
        Region region = new Region(body.name(),body.country());

        return regionRepository.save(region);
    }

    public List<Region> findByCountryCode(String code){
        return regionRepository.findByCountryCodeIgnoreCase(code);
    }
}
