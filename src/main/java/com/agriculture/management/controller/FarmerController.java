package com.agriculture.management.controller;

import com.agriculture.management.model.Farmer;
import com.agriculture.management.service.FarmerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {

    private final FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @PostMapping
    public Farmer create(@RequestBody Farmer farmer) {
        return farmerService.createFarmer(farmer);
    }

    @GetMapping
    public List<Farmer> getAll() {
        return farmerService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public Farmer getById(@PathVariable Long id) {
        return farmerService.getFarmerById(id);
    }

    @PutMapping("/{id}")
    public Farmer update(@PathVariable Long id, @RequestBody Farmer farmer) {
        return farmerService.updateFarmer(id, farmer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
    }
}