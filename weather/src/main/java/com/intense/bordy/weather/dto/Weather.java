package com.intense.bordy.weather.dto;

public class Weather {
    private String city;
    private String country;
    private String zip_code;
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
