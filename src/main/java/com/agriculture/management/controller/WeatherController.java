package com.agriculture.management.controller;

import com.agriculture.management.model.WeatherData;
import com.agriculture.management.service.WeatherService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping
    public WeatherData add(@RequestBody WeatherData weather) {
        return weatherService.addWeather(weather);
    }

    @GetMapping
    public List<WeatherData> getAll() {
        return weatherService.getAllWeather();
    }
}