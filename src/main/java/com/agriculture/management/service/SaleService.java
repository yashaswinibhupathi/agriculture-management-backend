package com.agriculture.management.service;

import com.agriculture.management.model.Sale;
import com.agriculture.management.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    public List<Sale> getByFarmer(Long farmerId) {
        return saleRepository.findByFarmerId(farmerId);
    }

    public List<Sale> getByPaymentStatus(Sale.PaymentStatus status) {
        return saleRepository.findByPaymentStatus(status);
    }

    public Double getTotalRevenue(Long farmerId) {
        return saleRepository.getTotalRevenueByFarmer(farmerId);
    }

    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}