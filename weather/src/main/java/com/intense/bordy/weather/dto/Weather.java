package com.intense.bordy.weather.dto;

import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "Name of City", name = "city", required = true, value = "Besancon")
    private String city;
    @ApiModelProperty(notes = "Name of Country 2 Char", name = "country", required = true, value = "FR")
    private String country;
    @ApiModelProperty(notes = "Zip Code of City", name = "zip code", required = true, value = "25000")
    private String zip_code;
    @ApiModelProperty(notes = "Weather of place", name = "weather", required = true, value = "il fait 5°C et il fait beau")
    private String weather;

    public Weather(String city, String country, String zip_code, String weather) {
        this.city = city;
        this.country = country;
        this.zip_code = zip_code;
        this.weather = weather;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
