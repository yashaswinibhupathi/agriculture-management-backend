package com.agriculture.management.service;

import com.agriculture.management.model.Field;
import com.agriculture.management.repository.FieldRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    public FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field getFieldById(Long id) {
        return fieldRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Field not found"));
    }

    public List<Field> getFieldsByFarmer(Long farmerId) {
        return fieldRepository.findByFarmerId(farmerId);
    }

    public Field updateField(Long id, Field field) {

        Field existing = getFieldById(id);

        existing.setName(field.getName());
        existing.setArea(field.getArea());
        existing.setSoilType(field.getSoilType());
        existing.setIrrigationType(field.getIrrigationType());
        existing.setLatitude(field.getLatitude());
        existing.setLongitude(field.getLongitude());

        return fieldRepository.save(existing);
    }

    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }
}