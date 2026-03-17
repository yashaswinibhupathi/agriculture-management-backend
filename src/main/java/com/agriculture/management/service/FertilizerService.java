package com.agriculture.management.service;

import com.agriculture.management.model.Fertilizer;
import com.agriculture.management.repository.FertilizerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FertilizerService {

    private final FertilizerRepository fertilizerRepository;

    public FertilizerService(FertilizerRepository fertilizerRepository) {
        this.fertilizerRepository = fertilizerRepository;
    }

    public Fertilizer createFertilizer(Fertilizer fertilizer) {
        return fertilizerRepository.save(fertilizer);
    }

    public List<Fertilizer> getAllFertilizers() {
        return fertilizerRepository.findAll();
    }

    public Fertilizer getFertilizerById(Long id) {
        return fertilizerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fertilizer not found"));
    }

    public List<Fertilizer> getByField(Long fieldId) {
        return fertilizerRepository.findByFieldId(fieldId);
    }

    public Fertilizer updateFertilizer(Long id, Fertilizer fertilizer) {

        Fertilizer existing = getFertilizerById(id);

        existing.setFertilizerName(fertilizer.getFertilizerName());
        existing.setType(fertilizer.getType());
        existing.setQuantity(fertilizer.getQuantity());
        existing.setUnit(fertilizer.getUnit());
        existing.setApplicationDate(fertilizer.getApplicationDate());

        return fertilizerRepository.save(existing);
    }

    public void deleteFertilizer(Long id) {
        fertilizerRepository.deleteById(id);
    }
}