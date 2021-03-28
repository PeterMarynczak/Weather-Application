package com.peter.weatherapp.WeatherApp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void weatherServiceDataShouldNotBeNullAfterEnteringProperCityName() throws JSONException {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub();
        //when
        JSONArray weatherArrayWithTemperatureInfoFromFiveDays = weatherServiceStub.getWeatherObject("Warsaw");
        //then
        assertNotNull(weatherArrayWithTemperatureInfoFromFiveDays);
    }

    @Test
    void weatherServiceDataShouldBeNullWhenEnteredCityIsNotProper() throws JSONException {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub();
        //when
        JSONArray weatherArrayWithTemperatureInfoFromFiveDays = weatherServiceStub.getWeatherObject("");
        //then
        assertNull(weatherArrayWithTemperatureInfoFromFiveDays);
    }

}