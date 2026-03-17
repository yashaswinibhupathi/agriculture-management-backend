package com.agriculture.management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "harvests")
public class Harvest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double quantity;
    private String unit;
    private LocalDate harvestDate;
    private String qualityGrade;
    private Double marketPrice;
    private Double totalValue;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = true)
    private Crop crop;

    public Harvest() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getQuantity() { return quantity; }

    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }

    public void setUnit(String unit) { this.unit = unit; }

    public LocalDate getHarvestDate() { return harvestDate; }

    public void setHarvestDate(LocalDate harvestDate) { this.harvestDate = harvestDate; }

    public String getQualityGrade() { return qualityGrade; }

    public void setQualityGrade(String qualityGrade) { this.qualityGrade = qualityGrade; }

    public Double getMarketPrice() { return marketPrice; }

    public void setMarketPrice(Double marketPrice) { this.marketPrice = marketPrice; }

    public Double getTotalValue() { return totalValue; }

    public void setTotalValue(Double totalValue) { this.totalValue = totalValue; }

    public Crop getCrop() { return crop; }

    public void setCrop(Crop crop) { this.crop = crop; }
}