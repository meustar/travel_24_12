package com.kgb.exam.travel_24_12.repository;


import com.kgb.exam.travel_24_12.vo.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WeatherRepository extends JpaRepository<Weather, Long> {
    List<Weather> findByCity(String city);
}