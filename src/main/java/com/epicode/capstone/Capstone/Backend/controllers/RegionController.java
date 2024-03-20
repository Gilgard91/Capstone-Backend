package com.epicode.capstone.Capstone.Backend.controllers;

import com.epicode.capstone.Capstone.Backend.dto.RegionDTO;
import com.epicode.capstone.Capstone.Backend.entities.Region;
import com.epicode.capstone.Capstone.Backend.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping
    public List<Region> getAllRegions(){
        return this.regionService.getRegionsList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Region saveRegion(@RequestBody RegionDTO region){
        return this.regionService.saveRegion(region);
    }

    @GetMapping("/findByCountryCode")
    public List<Region> findByCountryCode(@RequestParam String code){
        return this.regionService.findByCountryCode(code);
    }
}
