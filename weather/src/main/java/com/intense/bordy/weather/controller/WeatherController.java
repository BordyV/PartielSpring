package com.intense.bordy.weather.controller;

import com.intense.bordy.weather.dto.Weather;
import com.intense.bordy.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @GetMapping("/")
    public List<Weather> getWeather() {
        return weatherService.getAllWeather();
    }

    @GetMapping( "/getWeatherByCountry/{countryCode}")
    public List<Weather> getWeatherByCountry(@PathVariable(value = "countryCode") String countryCode) {
        return weatherService.getWeatherByCountry(countryCode);
    }

    @GetMapping( "/getWeatherByCity/{city}")
    public Weather getWeatherByCity(@PathVariable(value = "city") String city) {
        return weatherService.getWeatherByCity(city);
    }

    @GetMapping( "/getWeatherByZipCode/{zipCode}")
    public Weather getWeatherByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return weatherService.getWeatherByZipCode(zipCode);
    }
}
