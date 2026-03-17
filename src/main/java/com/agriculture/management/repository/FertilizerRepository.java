package com.agriculture.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agriculture.management.model.Fertilizer;

import java.util.List;

@Repository
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {
    List<Fertilizer> findByFieldId(Long fieldId);
    List<Fertilizer> findByFieldFarmerId(Long farmerId);
}
