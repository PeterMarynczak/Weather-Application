package com.peter.weatherapp.WeatherApp.model;

import org.json.JSONArray;
import org.json.JSONException;

public class WeatherServiceStub {

    private String cityName;

    public WeatherServiceStub(String cityName) {
        this.cityName = cityName;
    }
    public WeatherServiceStub( ) {

    }

    public JSONArray getWeatherObject() throws JSONException {

        if(cityName != null) {
            JSONArray weatherDataFromFiveDays = new JSONArray("[" +
                    "{\"cityNAme\": " + cityName + "}," +
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
