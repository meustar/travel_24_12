package com.kgb.exam.travel_24_12.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TouristSpot {

    @JsonProperty("title")
    private String title; // 관광지 이름

    @JsonProperty("addr1")
    private String addr1; // 주소

    @JsonProperty("firstimage")
    private String firstImage; // 대표 이미지 (optional)

    @JsonProperty("mapx")
    private double longitude; // 경도

    @JsonProperty("mapy")
    private double latitude; // 위도

    /**
     * 모든 필드를 포함한 생성자
     *
     * @param title      관광지 이름
     * @param addr1      주소
     * @param firstImage 대표 이미지 URL (nullable)
     * @param longitude  경도
     * @param latitude   위도
     */
    public TouristSpot(String title, String addr1, String firstImage, double longitude, double latitude) {
        this.title = title;
        this.addr1 = addr1;
        this.firstImage = firstImage;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    /**
     * 대표 이미지 없이 생성하는 생성자
     *
     * @param title     관광지 이름
     * @param addr1     주소
     * @param longitude 경도
     * @param latitude  위도
     */
    public TouristSpot(String title, String addr1, double longitude, double latitude) {
        this.title = title;
        this.addr1 = addr1;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "TouristSpot{" +
                "title='" + title + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", firstImage='" + (firstImage != null ? firstImage : "N/A") + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
