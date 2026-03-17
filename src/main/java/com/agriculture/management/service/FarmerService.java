package com.agriculture.management.service;

import com.agriculture.management.model.Farmer;
import com.agriculture.management.repository.FarmerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }

    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
    }

    public Farmer updateFarmer(Long id, Farmer farmer) {

        Farmer existing = getFarmerById(id);

        existing.setPhone(farmer.getPhone());
        existing.setAddress(farmer.getAddress());
        existing.setFarmName(farmer.getFarmName());
        existing.setTotalLandArea(farmer.getTotalLandArea());
        existing.setExperienceYears(farmer.getExperienceYears());

        return farmerRepository.save(existing);
    }

    public void deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
    }
}