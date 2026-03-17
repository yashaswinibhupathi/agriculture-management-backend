package com.agriculture.management.controller;

import com.agriculture.management.model.Harvest;
import com.agriculture.management.service.HarvestService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvests")
public class HarvestController {

    private final HarvestService harvestService;

    public HarvestController(HarvestService harvestService) {
        this.harvestService = harvestService;
    }

    @PostMapping
    public Harvest create(@RequestBody Harvest harvest) {
        return harvestService.createHarvest(harvest);
    }

    @GetMapping
    public List<Harvest> getAll() {
        return harvestService.getAllHarvests();
    }

    @GetMapping("/{id}")
    public Harvest getById(@PathVariable Long id) {
        return harvestService.getHarvestById(id);
    }

    @GetMapping("/crop/{cropId}")
    public List<Harvest> getByCrop(@PathVariable Long cropId) {
        return harvestService.getByCrop(cropId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        harvestService.deleteHarvest(id);
    }
}