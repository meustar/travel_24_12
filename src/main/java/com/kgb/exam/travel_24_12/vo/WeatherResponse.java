package com.kgb.exam.travel_24_12.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    @JsonProperty("name")
    private String city; // 도시 이름

    @JsonProperty("main")
    private Main main; // 온도 및 습도 정보

    @JsonProperty("wind")
    private Wind wind; // 풍속 정보

    @Data
    public static class Main {
        @JsonProperty("temp")
        private double temperature; // 온도

        @JsonProperty("humidity")
        private int humidity; // 습도
    }

    @Data
    public static class Wind {
        @JsonProperty("speed")
        private double speed; // 풍속
    }
}
