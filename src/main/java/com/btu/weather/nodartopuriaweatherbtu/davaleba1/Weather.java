package com.btu.weather.nodartopuriaweatherbtu.davaleba1;

public class Weather {

    enum DirectionType {
        NORTH, SOUTH, EAST, WEST
    }

    public String cityName;
    private Double temperature;
    private int humidity;
    private int pressure;
    private int windSpeed;
    private DirectionType windDirection;

    public Weather(String cityName, double temperature, int humidity, int pressure, int windSpeed, DirectionType windDirection) {
        this.cityName = cityName;
        this.humidity = humidity;
        this.pressure = pressure;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
    }

    public Weather() {
    }


}
