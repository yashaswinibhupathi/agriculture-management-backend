package com.agriculture.management.controller;

import com.agriculture.management.service.ReportService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/revenue/{farmerId}")
    public Double getRevenue(@PathVariable Long farmerId) {
        return reportService.getTotalRevenue(farmerId);
    }
}