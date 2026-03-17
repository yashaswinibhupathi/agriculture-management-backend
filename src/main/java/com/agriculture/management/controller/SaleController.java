package com.agriculture.management.controller;

import com.agriculture.management.model.Sale;
import com.agriculture.management.service.SaleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public Sale create(@RequestBody Sale sale) {
        return saleService.createSale(sale);
    }

    @GetMapping
    public List<Sale> getAll() {
        return saleService.getAllSales();
    }

    @GetMapping("/farmer/{farmerId}")
    public List<Sale> getByFarmer(@PathVariable Long farmerId) {
        return saleService.getByFarmer(farmerId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        saleService.deleteSale(id);
    }
}