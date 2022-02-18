package com.intense.bordy.showweather.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ShowWeatherService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethodGetWeatherByCity")
    public String getWeatherByCity(String city) {
        String response = restTemplate
                .exchange("http://localhost:8080/getWeatherByCity/{city}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, city).getBody();

        return "Wether for " + city + " :::   " + response;
    }

    public String fallbackMethodGetWeatherByCity(String city) {
        return "FallBack response: No Meteo Weather By City available for now";
    }

    @HystrixCommand(fallbackMethod = "fallbackMethodGetWeatherByZipCode")
    public String getWeatherByZipCode(String zipCode) {
        String response = restTemplate
                .exchange("http://localhost:8080/getWeatherByZipCode/{zipCode}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, zipCode).getBody();

        return "Wether for " + zipCode + " :::   " + response;
    }

    public String fallbackMethodGetWeatherByZipCode(String zipCode) {
        return "FallBack response: No Meteo Weather By ZipCode available for now";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
