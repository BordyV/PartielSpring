package com.intense.bordy.weather.service;

import com.intense.bordy.weather.dto.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private static List<Weather> weatherList;

    static {
        weatherList = new ArrayList<>();
        weatherList.add(new Weather("Nice","FR","06000","Il fait 15°C et un soleil le " + new Date()));
        weatherList.add(new Weather("Besancon","FR","25000","Il fait -1°C et il neige le " + new Date()));
        weatherList.add(new Weather("Paris","FR","75000","Il fait 5°C et un soleil le " + new Date()));
        weatherList.add(new Weather("Sion","CH","1950","Il fait -5°C et il pleut le " + new Date()));
        weatherList.add(new Weather("Mexico","MX","00810","Il fait 25°C et un soleil le " + new Date()));
    }

    public List<Weather> getAllWeather() {
        return weatherList;
    }

    public List<Weather> getWeatherByCountry(String countryCode) {
    return weatherList.stream().filter(weather -> weather.getCountry().equalsIgnoreCase(countryCode))
            .collect(Collectors.toList());
    }

    public Weather getWeatherByZipCode(String zipCode) {
        return weatherList.stream().filter(weather -> weather.getZip_code().equalsIgnoreCase(zipCode))
                .collect(Collectors.toList()).get(0);
    }

    public Weather getWeatherByCity(String city) {
        return weatherList.stream().filter(weather -> weather.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList()).get(0);
    }
}
