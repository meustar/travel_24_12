
package com.kgb.exam.travel_24_12.service;

import com.kgb.exam.travel_24_12.vo.TouristResponse;
import com.kgb.exam.travel_24_12.vo.TouristSpot;
import com.kgb.exam.travel_24_12.vo.Weather;
import com.kgb.exam.travel_24_12.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class TourService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${api.public-data-key}")
    private String publicDataApiKey;

    @Value("${api.openweather-key}")
    private String openWeatherApiKey;

    public List<TouristSpot> getTouristSpots(String areaCode) {
        // JSON 응답을 요청하는 URL
        String url = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1"
                + "?serviceKey=" + publicDataApiKey
                + "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=TravelApp&areaCode=" + areaCode
                + "&_type=json"; // JSON 형식 요청

        // JSON 응답을 TouristResponse로 매핑
        TouristResponse response = restTemplate.getForObject(url, TouristResponse.class);

        // 응답 데이터에서 관광지 리스트 추출
        if (response != null && response.getResponse() != null &&
                response.getResponse().getBody() != null &&
                response.getResponse().getBody().getItems() != null) {
            return response.getResponse().getBody().getItems().getItemList();
        }

        return Collections.emptyList(); // 데이터가 없으면 빈 리스트 반환
    }

    public WeatherResponse getWeatherForArea(String cityName) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + cityName + "&appid=" + openWeatherApiKey + "&units=metric";

        return restTemplate.getForObject(url, WeatherResponse.class);
    }

    public Weather createWeatherWithTouristSpot(WeatherResponse weatherResponse, TouristSpot touristSpot) {
        Weather weather = new Weather();
        weather.setCity(weatherResponse.getCity()); // 도시 이름 설정
        weather.setTemperature(weatherResponse.getMain().getTemperature()); // 온도 설정
        weather.setHumidity(weatherResponse.getMain().getHumidity()); // 습도 설정
        weather.setWindSpeed(weatherResponse.getWind().getSpeed()); // 풍속 설정
        weather.setTimestamp(LocalDateTime.now());

        // TouristSpot 데이터를 비영속적으로 설정
        weather.setTouristSpot(touristSpot);

        return weather;
    }

}
