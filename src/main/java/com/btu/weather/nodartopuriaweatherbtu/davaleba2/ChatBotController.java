package com.btu.weather.nodartopuriaweatherbtu.davaleba2;

import com.btu.weather.nodartopuriaweatherbtu.davaleba1.Weather;
import com.btu.weather.nodartopuriaweatherbtu.davaleba1.WeatherService;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.List;
import java.util.Locale;

@ServerEndpoint("/chatbot")
public class ChatBotController {

    private final WeatherService weatherService;

    @Inject
    public ChatBotController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @OnOpen
    public void handleOpen() {
        System.out.println("Connected to ChatBot");
        System.out.println("Hello My Name is WeatherWizard");
        System.out.println("Tell me city names and I will tell you weather");
        System.out.println("or type ALL and you will see everything");
        System.out.println("I am new here, so i Only Know 3 Cities yet");
        System.out.println("Ask about Tbilis,Kutaisi or Batumi");
    }

    @OnMessage
    public String handleMessage(String message) {
        String request = message.toLowerCase(Locale.ROOT);
        List<Weather> weatherList;
        String cityAnswer = "Cannot Find That City";
        StringBuilder all = new StringBuilder();
        if(request.equals("all")){
            weatherList = weatherService.getWeather();
            for (Weather x : weatherList) {
                all.append(x);
                System.out.println(x);
            }
            return all.toString();
        }else{
            if(weatherService.getWeatherCity(request) == null){
                return cityAnswer;
            }else{
                return weatherService.getWeatherCity(request).toString();
            }

        }
    }

    @OnClose
    public void handleClose() {
        System.out.println("Bye Bye :)");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

}
