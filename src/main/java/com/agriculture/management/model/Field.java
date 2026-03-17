package com.agriculture.management.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double area;
    private String soilType;
    private String irrigationType;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = true)
    private Farmer farmer;

    @OneToMany(mappedBy = "field")
    private List<Crop> crops;

    public Field() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getArea() { return area; }

    public void setArea(Double area) { this.area = area; }

    public String getSoilType() { return soilType; }

    public void setSoilType(String soilType) { this.soilType = soilType; }

    public String getIrrigationType() { return irrigationType; }

    public void setIrrigationType(String irrigationType) { this.irrigationType = irrigationType; }

    public Double getLatitude() { return latitude; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }

    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Farmer getFarmer() { return farmer; }

    public void setFarmer(Farmer farmer) { this.farmer = farmer; }

    public List<Crop> getCrops() { return crops; }

    public void setCrops(List<Crop> crops) { this.crops = crops; }
}