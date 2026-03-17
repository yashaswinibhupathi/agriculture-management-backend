package com.agriculture.management.service;

import com.agriculture.management.repository.SaleRepository;

import org.springframework.stereotype.Service;

@Service
public class ReportService {

    private final SaleRepository saleRepository;

    public ReportService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Double getTotalRevenue(Long farmerId) {
        return saleRepository.getTotalRevenueByFarmer(farmerId);
    }
}