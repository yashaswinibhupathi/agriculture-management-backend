package com.agriculture.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agriculture.management.model.Crop;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByFieldId(Long fieldId);

    List<Crop> findByStatus(Crop.CropStatus status);

    List<Crop> findByFieldFarmerId(Long farmerId);
}