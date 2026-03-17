package com.agriculture.management.service;
 
import com.agriculture.management.model.Equipment;
import com.agriculture.management.repository.EquipmentRepository;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class EquipmentService {
 
    private final EquipmentRepository equipmentRepository;
 
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
 
    public Equipment create(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
 
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }
 
    public Equipment getById(Long id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
    }
 
    public List<Equipment> getByFarmer(Long farmerId) {
        return equipmentRepository.findByFarmerId(farmerId);
    }
 
    public Equipment update(Long id, Equipment updated) {
        Equipment existing = getById(id);
        existing.setName(updated.getName());
        existing.setType(updated.getType());
        existing.setModel(updated.getModel());
        existing.setSerialNumber(updated.getSerialNumber());
        existing.setStatus(updated.getStatus());
        existing.setPurchaseDate(updated.getPurchaseDate());
        existing.setLastMaintenanceDate(updated.getLastMaintenanceDate());
        existing.setNextMaintenanceDate(updated.getNextMaintenanceDate());
        existing.setLocation(updated.getLocation());
        existing.setNotes(updated.getNotes());
        return equipmentRepository.save(existing);
    }
 
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}