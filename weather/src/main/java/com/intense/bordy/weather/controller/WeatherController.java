package com.intense.bordy.weather.controller;

import com.intense.bordy.weather.dto.Weather;
import com.intense.bordy.weather.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Weather", description = "REST Apis related to Weathers Entity!!!!")
@RestController
public class WeatherController {
    @Autowired
    WeatherService weatherService;

    @ApiOperation(value = "Get list of all Weather ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @GetMapping("/")
    public List<Weather> getWeather() {
        return weatherService.getAllWeather();
    }

    @ApiOperation(value = "Get Weather by country ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping( "/getWeatherByCountry/{countryCode}")
    public List<Weather> getWeatherByCountry(@PathVariable(value = "countryCode") String countryCode) {
        return weatherService.getWeatherByCountry(countryCode);
    }

    @ApiOperation(value = "Get Weather by City ", response = Weather.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Servor error!!!")
    })
    @GetMapping( "/getWeatherByCity/{city}")
    public Weather getWeatherByCity(@PathVariable(value = "city") String city) {
        return weatherService.getWeatherByCity(city);
    }

    @ApiOperation(value = "Get Weather by ZIp Code ", response = Weather.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!"),
            @ApiResponse(code = 500, message = "Servor error!!!")
    })
    @GetMapping( "/getWeatherByZipCode/{zipCode}")
    public Weather getWeatherByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return weatherService.getWeatherByZipCode(zipCode);
    }
}
