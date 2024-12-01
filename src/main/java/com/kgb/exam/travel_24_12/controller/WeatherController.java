package com.kgb.exam.travel_24_12.controller;

import com.kgb.exam.travel_24_12.service.WeatherService;
import com.kgb.exam.travel_24_12.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam(defaultValue = "Seoul") String city, Model model) {
        // 예시로 서울의 nx, ny 값을 넣음
        String nx = "60";
        String ny = "127";

        Weather weather = weatherService.getWeather(city, nx, ny);
        model.addAttribute("city", city);
        model.addAttribute("weather", weather);
        return "weather";
    }
}