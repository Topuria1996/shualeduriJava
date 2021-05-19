package com.btu.weather.nodartopuriaweatherbtu.davaleba1;

import java.util.ArrayList;
import java.util.List;


public class WeatherServiceImpl implements WeatherService{
    List<Weather> weatherList = new ArrayList<>();
    @Override
    public List<Weather> getWeather() {
        return weatherList;
    }

    @Override
    public Weather getWeatherCity(String cityName) {
        Weather cityWeather = null;
        for (Weather x: weatherList) {
            if(x.cityName.equals(cityName)){
                cityWeather = x;
            }
        }
        return cityWeather;
    }

    @Override
    public void setWeather() {
        String[] cityNames = {"Tbilisi","Batumi","Kutaisi"};
        System.out.println(Weather.DirectionType.values()[1]);
        for(int i = 0;i<cityNames.length;i++){
            Weather weatherObject = new Weather(cityNames[i],23.3,12,13,14, Weather.DirectionType.values()[i]);
        }
    }
}
