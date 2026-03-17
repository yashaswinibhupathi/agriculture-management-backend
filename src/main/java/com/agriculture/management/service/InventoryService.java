package com.agriculture.management.service;

import com.agriculture.management.model.Inventory;
import com.agriculture.management.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public Inventory addItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllItems() {
        return inventoryRepository.findAll();
    }

    public Inventory getItemById(Long id) {
        return inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<Inventory> getBySupplier(Long supplierId) {
        return inventoryRepository.findBySupplierId(supplierId);
    }

    public List<Inventory> getByCategory(String category) {
        return inventoryRepository.findByCategory(category);
    }

    public List<Inventory> getByStockStatus(Inventory.StockStatus status) {
        return inventoryRepository.findByStockStatus(status);
    }

    public Inventory updateItem(Long id, Inventory inventory) {

        Inventory existing = getItemById(id);

        existing.setProductName(inventory.getProductName());
        existing.setCategory(inventory.getCategory());
        existing.setQuantity(inventory.getQuantity());
        existing.setPricePerUnit(inventory.getPricePerUnit());
        existing.setStockStatus(inventory.getStockStatus());

        return inventoryRepository.save(existing);
    }

    public void deleteItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}