package com.agriculture.management.service;

import com.agriculture.management.model.Crop;
import com.agriculture.management.repository.CropRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    private final CropRepository cropRepository;

    public CropService(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    public Crop getCropById(Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found"));
    }

    public List<Crop> getCropsByField(Long fieldId) {
        return cropRepository.findByFieldId(fieldId);
    }

    public List<Crop> getCropsByFarmer(Long farmerId) {
        return cropRepository.findByFieldFarmerId(farmerId);
    }

    public List<Crop> getCropsByStatus(Crop.CropStatus status) {
        return cropRepository.findByStatus(status);
    }

    public Crop updateCrop(Long id, Crop crop) {

        Crop existing = getCropById(id);

        existing.setName(crop.getName());
        existing.setVariety(crop.getVariety());
        existing.setSeason(crop.getSeason());
        existing.setStatus(crop.getStatus());
        existing.setExpectedYield(crop.getExpectedYield());

        return cropRepository.save(existing);
    }

    public void deleteCrop(Long id) {
        cropRepository.deleteById(id);
    }
}