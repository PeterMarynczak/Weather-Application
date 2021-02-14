package com.peter.weatherapp.WeatherApp.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WeatherService {
    private OkHttpClient client;
    private Response response;

    public JSONObject getWeather(String name) throws JSONException {

        client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather?q="+name+"&units=imperial&appid=36dee2f719fcadc7bbed52c0d7c39b75")
                .build();

        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public JSONArray returnWeatherArray(String name) throws JSONException {
        JSONArray weatherJsonArray = getWeather(name).getJSONArray("weather");
        return weatherJsonArray;
    }

    public JSONObject returnMainObject(String name) throws JSONException {
        JSONObject mainObject = getWeather(name).getJSONObject("main");
        return mainObject;
    }

    public JSONObject returnWindObject(String name) throws JSONException {
        JSONObject windObject = getWeather(name).getJSONObject("wind");
        return windObject;
    }

    public JSONObject returnSunSet(String name) throws JSONException {
        JSONObject sunObject = getWeather(name).getJSONObject("sys");
        return sunObject;
    }

}
