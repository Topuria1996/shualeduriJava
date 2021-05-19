package com.btu.weather.nodartopuriaweatherbtu.davaleba1;

import java.util.List;

public interface WeatherService {
    List<Weather> getWeather();
    Weather getWeatherCity(String cityName);
    void setWeather();
}
