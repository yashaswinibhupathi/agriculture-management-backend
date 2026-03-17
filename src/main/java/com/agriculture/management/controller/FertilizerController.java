package com.agriculture.management.controller;

import com.agriculture.management.model.Fertilizer;
import com.agriculture.management.service.FertilizerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizers")
public class FertilizerController {

    private final FertilizerService fertilizerService;

    public FertilizerController(FertilizerService fertilizerService) {
        this.fertilizerService = fertilizerService;
    }

    @PostMapping
    public Fertilizer create(@RequestBody Fertilizer fertilizer) {
        return fertilizerService.createFertilizer(fertilizer);
    }

    @GetMapping
    public List<Fertilizer> getAll() {
        return fertilizerService.getAllFertilizers();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fertilizerService.deleteFertilizer(id);
    }
}