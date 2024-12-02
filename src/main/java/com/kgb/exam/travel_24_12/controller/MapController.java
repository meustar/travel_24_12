package com.kgb.exam.travel_24_12.controller;

import com.kgb.exam.travel_24_12.vo.TouristSpot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Value("${api.kakao-map-key}")
    private String kakaoMapKey;

    @GetMapping("/map")
    public String showMap(Model model) {
        // tourist 객체를 생성합니다.
        TouristSpot tourist = new TouristSpot("Gwanghwamun", "광화문은 한국의 랜드마크 중 하나입니다.", null, 126.9768, 37.5759);

        // tourist와 kakaoMapKey를 모델에 추가합니다.
        model.addAttribute("tourist", tourist);
        model.addAttribute("kakaoMapKey", kakaoMapKey);

        return "weather"; // 템플릿 이름
    }
}
