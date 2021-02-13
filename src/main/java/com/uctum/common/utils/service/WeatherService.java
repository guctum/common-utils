package com.uctum.common.utils.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {

    @Value("${weather.apikey")
    private String apiKey;

    public String getWeather(String city) {
        StringBuilder weather = new StringBuilder();
        try {
            String url = "api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            UtilsService.getFromUrl(weather, url);
            System.out.println(url);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return weather.toString();
    }

    public String getWeather(String city, String state) {
        StringBuilder weather = new StringBuilder();
        try {
            String url = "api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            UtilsService.getFromUrl(weather, url);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
        return weather.toString();
    }
}
