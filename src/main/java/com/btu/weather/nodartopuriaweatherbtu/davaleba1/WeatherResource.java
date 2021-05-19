package com.btu.weather.nodartopuriaweatherbtu.davaleba1;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

//http://localhost:8080/nodartopuriaweatherbtu-1.0-SNAPSHOT/api/weather
@Path("/weather")
public class WeatherResource {
    private final WeatherService weatherService;

    @Inject
    public WeatherResource(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Weather> getWeather() {
        weatherService.setWeather();
        return weatherService.getWeather();
    }

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public Weather getWeatherCity(@PathParam("city") String cityName) {
        weatherService.setWeather();
        return weatherService.getWeatherCity(cityName);
    }
}