package com.agriculture.management.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather")
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private Double temperature;
    private Double humidity;
    private Double rainfall;
    private Double windSpeed;

    private LocalDate date;

    public WeatherData() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Double getTemperature() { return temperature; }

    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getHumidity() { return humidity; }

    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public Double getRainfall() { return rainfall; }

    public void setRainfall(Double rainfall) { this.rainfall = rainfall; }

    public Double getWindSpeed() { return windSpeed; }

    public void setWindSpeed(Double windSpeed) { this.windSpeed = windSpeed; }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }
}