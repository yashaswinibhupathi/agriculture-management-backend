package com.agriculture.management.controller;

import com.agriculture.management.model.Crop;
import com.agriculture.management.service.CropService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @PostMapping
    public Crop create(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    @GetMapping
    public List<Crop> getAll() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @GetMapping("/field/{fieldId}")
    public List<Crop> getByField(@PathVariable Long fieldId) {
        return cropService.getCropsByField(fieldId);
    }

    @PutMapping("/{id}")
    public Crop update(@PathVariable Long id, @RequestBody Crop crop) {
        return cropService.updateCrop(id, crop);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cropService.deleteCrop(id);
    }
}