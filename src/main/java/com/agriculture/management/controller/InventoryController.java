package com.agriculture.management.controller;

import com.agriculture.management.model.Inventory;
import com.agriculture.management.service.InventoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public Inventory add(@RequestBody Inventory inventory) {
        return inventoryService.addItem(inventory);
    }

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.getAllItems();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable Long id) {
        return inventoryService.getItemById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inventoryService.deleteItem(id);
    }
}