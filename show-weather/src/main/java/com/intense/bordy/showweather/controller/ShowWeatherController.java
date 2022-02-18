package com.intense.bordy.showweather.controller;

import com.intense.bordy.showweather.service.ShowWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowWeatherController {

    @Autowired
    ShowWeatherService showWeatherService;

    @GetMapping(value = "/getWeatherByCity/{city}")
    public String getWeatherByCity(@PathVariable String city) {
        return showWeatherService.getWeatherByCity(city);
    }

    @GetMapping(value = "/getWeatherByZipCode/{zipCode}")
    public String getWeatherByZipCode(@PathVariable String zipCode) {
        return showWeatherService.getWeatherByZipCode(zipCode);
    }

}
