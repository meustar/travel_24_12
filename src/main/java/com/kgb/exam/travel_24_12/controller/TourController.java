package com.kgb.exam.travel_24_12.controller;

import com.kgb.exam.travel_24_12.service.TourService;
import com.kgb.exam.travel_24_12.vo.TouristSpot;
import com.kgb.exam.travel_24_12.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TourController {

    @Autowired
    private TourService tourService;

    @GetMapping("/")
    public String home() {
        return "home"; // 기본 홈 페이지 템플릿
    }

    @GetMapping("/tour")
    public String getTourInfo(@RequestParam(required = false) String areaCode, Model model) {
        if (areaCode == null || areaCode.isBlank()) {
            model.addAttribute("errorMessage", "지역 코드를 입력해야 합니다.");
            return "error"; // 에러 템플릿 표시
        }

        List<TouristSpot> spots = tourService.getTouristSpots(areaCode);
        WeatherResponse weather = tourService.getWeatherForArea(areaCode);

        model.addAttribute("spots", spots);
        model.addAttribute("weather", weather);

        return "tour"; // 관광지 및 날씨 정보를 표시하는 템플릿
    }
}
