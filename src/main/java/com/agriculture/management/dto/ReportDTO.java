package com.agriculture.management.dto;

public class ReportDTO {

    private Long farmerId;
    private Double totalRevenue;

    public ReportDTO() {}

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}