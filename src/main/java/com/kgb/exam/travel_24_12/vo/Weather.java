package com.kgb.exam.travel_24_12.vo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city; // 도시 이름
    private double temperature; // 온도
    private int humidity; // 습도
    private double windSpeed; // 풍속
    private LocalDateTime timestamp; // 데이터 기록 시간

    // TouristSpot은 비영속 데이터로 처리
    @Transient
    private TouristSpot touristSpot; // 외래 키가 아닌 비영속 필드로 선언

    public Weather() {
    }

    public Weather(String city, double temperature, int humidity, double windSpeed, LocalDateTime timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.timestamp = timestamp;
    }
}
