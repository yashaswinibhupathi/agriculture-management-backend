package com.agriculture.management.service;

import com.agriculture.management.model.Harvest;
import com.agriculture.management.repository.HarvestRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestService {

    private final HarvestRepository harvestRepository;

    public HarvestService(HarvestRepository harvestRepository) {
        this.harvestRepository = harvestRepository;
    }

    public Harvest createHarvest(Harvest harvest) {
        return harvestRepository.save(harvest);
    }

    public List<Harvest> getAllHarvests() {
        return harvestRepository.findAll();
    }

    public Harvest getHarvestById(Long id) {
        return harvestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Harvest not found"));
    }

    public List<Harvest> getByCrop(Long cropId) {
        return harvestRepository.findByCropId(cropId);
    }

    public Harvest updateHarvest(Long id, Harvest harvest) {

        Harvest existing = getHarvestById(id);

        existing.setQuantity(harvest.getQuantity());
        existing.setUnit(harvest.getUnit());
        existing.setHarvestDate(harvest.getHarvestDate());
        existing.setQualityGrade(harvest.getQualityGrade());
        existing.setMarketPrice(harvest.getMarketPrice());
        existing.setTotalValue(harvest.getTotalValue());

        return harvestRepository.save(existing);
    }

    public void deleteHarvest(Long id) {
        harvestRepository.deleteById(id);
    }
}