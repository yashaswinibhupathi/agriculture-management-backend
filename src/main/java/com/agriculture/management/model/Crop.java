package com.agriculture.management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crops")
public class Crop {

    public enum CropStatus {
        PLANTED,
        GROWING,
        HARVESTED,
        FAILED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String variety;
    private String season;

    private LocalDate plantingDate;
    private LocalDate expectedHarvestDate;

    private Double expectedYield;

    @Enumerated(EnumType.STRING)
    private CropStatus status;

    @ManyToOne
    @JoinColumn(name = "field_id", nullable = true)
    private Field field;

    public Crop() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public LocalDate getPlantingDate() { return plantingDate; }
    public void setPlantingDate(LocalDate plantingDate) { this.plantingDate = plantingDate; }

    public LocalDate getExpectedHarvestDate() { return expectedHarvestDate; }
    public void setExpectedHarvestDate(LocalDate expectedHarvestDate) { this.expectedHarvestDate = expectedHarvestDate; }

    public Double getExpectedYield() { return expectedYield; }
    public void setExpectedYield(Double expectedYield) { this.expectedYield = expectedYield; }

    public CropStatus getStatus() { return status; }
    public void setStatus(CropStatus status) { this.status = status; }

    public Field getField() { return field; }
    public void setField(Field field) { this.field = field; }
}