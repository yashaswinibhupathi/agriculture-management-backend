package com.agriculture.management.dto;

public class FarmerDTO {

    private Long id;
    private String phone;
    private String address;
    private String farmName;
    private Double totalLandArea;
    private Integer experienceYears;

    public FarmerDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Double getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(Double totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }
}