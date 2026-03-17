package com.agriculture.management.service;

import com.agriculture.management.model.WeatherData;
import com.agriculture.management.repository.WeatherRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public WeatherData addWeather(WeatherData weather) {
        return weatherRepository.save(weather);
    }

    public List<WeatherData> getAllWeather() {
        return weatherRepository.findAll();
    }

    public List<WeatherData> getByLocation(String location) {
        return weatherRepository.findByLocation(location);
    }
}