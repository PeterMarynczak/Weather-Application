package com.peter.weatherapp.WeatherApp.model;

import org.json.JSONArray;
import org.json.JSONException;

public class WeatherServiceStub {

    public JSONArray getWeatherObject(String cityName) throws JSONException {

        if(cityName != "") {
            JSONArray weatherDataFromFiveDays = new JSONArray("[" +
                    "{\"tempFromFirstDay\": 15}," +
                    "{\"tempFromSecondDay\": 18}," +
                    "{\"tempFromThirdDay\": 11}," +
                    "{\"tempFromFourthDay\": 20}," +
                    "{\"tempFromFourthDay\": 20}" +
                    "]");
            return weatherDataFromFiveDays;
        }
        else return null;
        }
}
