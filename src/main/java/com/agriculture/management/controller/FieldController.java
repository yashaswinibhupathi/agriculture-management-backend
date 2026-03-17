package com.agriculture.management.controller;

import com.agriculture.management.model.Field;
import com.agriculture.management.service.FieldService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
public class FieldController {

    private final FieldService fieldService;

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping
    public Field create(@RequestBody Field field) {
        return fieldService.createField(field);
    }

    @GetMapping
    public List<Field> getAll() {
        return fieldService.getAllFields();
    }

    @GetMapping("/{id}")
    public Field getById(@PathVariable Long id) {
        return fieldService.getFieldById(id);
    }

    @GetMapping("/farmer/{farmerId}")
    public List<Field> getByFarmer(@PathVariable Long farmerId) {
        return fieldService.getFieldsByFarmer(farmerId);
    }

    @PutMapping("/{id}")
    public Field update(@PathVariable Long id, @RequestBody Field field) {
        return fieldService.updateField(id, field);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fieldService.deleteField(id);
    }
}