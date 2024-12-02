package com.kgb.exam.travel_24_12.dto;

import lombok.Data;

@Data
public class WeatherResponse {
    private Main main;

    @Data
    public static class Main {
        private double temp;
        private int humidity;
    }
}