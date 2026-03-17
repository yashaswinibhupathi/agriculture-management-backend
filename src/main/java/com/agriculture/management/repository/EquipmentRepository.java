package com.agriculture.management.repository;

import com.agriculture.management.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
    List<Equipment> findByFarmerId(Long farmerId);
    List<Equipment> findByStatus(Equipment.EquipmentStatus status);
}
