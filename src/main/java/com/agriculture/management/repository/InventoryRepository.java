package com.agriculture.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agriculture.management.model.Inventory;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySupplierId(Long supplierId);
    List<Inventory> findByCategory(String category);
    List<Inventory> findByStockStatus(Inventory.StockStatus status);
}
