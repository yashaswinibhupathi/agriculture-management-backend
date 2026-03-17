package com.agriculture.management.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String address;
    private String nationalId;
    private String farmName;
    private Double totalLandArea;
    private Integer experienceYears;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @OneToMany(mappedBy = "farmer")
    private List<Field> fields;

    public Farmer() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getNationalId() { return nationalId; }

    public void setNationalId(String nationalId) { this.nationalId = nationalId; }

    public String getFarmName() { return farmName; }

    public void setFarmName(String farmName) { this.farmName = farmName; }

    public Double getTotalLandArea() { return totalLandArea; }

    public void setTotalLandArea(Double totalLandArea) { this.totalLandArea = totalLandArea; }

    public Integer getExperienceYears() { return experienceYears; }

    public void setExperienceYears(Integer experienceYears) { this.experienceYears = experienceYears; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<Field> getFields() { return fields; }

    public void setFields(List<Field> fields) { this.fields = fields; }
}