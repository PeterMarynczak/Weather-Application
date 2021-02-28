package com.peter.weatherapp.WeatherApp.model;

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

    private OkHttpClient client = new OkHttpClient();

    private JSONObject getWeather(String firstLocation, String defaultUnit) throws JSONException {

        Response response;

        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/forecast?q=" + firstLocation + "&units=" + defaultUnit + "&APPID=36dee2f719fcadc7bbed52c0d7c39b75")
                .build();
        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getWeatherObject(String firstLocation, String defaultUnit) throws JSONException {
        return getWeather(firstLocation, defaultUnit).getJSONArray("list");
    }
}
