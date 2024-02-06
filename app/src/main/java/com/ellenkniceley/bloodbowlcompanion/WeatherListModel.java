package com.ellenkniceley.bloodbowlcompanion;

public class WeatherListModel {
    String weatherNumber;
    String weatherTitle;
    String weatherDescription;


    public WeatherListModel(String weatherNumber, String weatherTitle, String weatherDescription) {
        this.weatherNumber = weatherNumber;
        this.weatherTitle = weatherTitle;
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherNumber() {
        return weatherNumber;
    }

    public String getWeatherTitle() {
        return weatherTitle;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }
}
