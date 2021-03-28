package com.peter.weatherapp.WeatherApp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class WeatherServiceTest {

    @Test
    void weatherServiceDataShouldNotBeNullAfterEnteringProperCityName() throws JSONException {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub("Warsaw");
        //when
        JSONArray weatherArrayWithTemperatureInfoFromFiveDays = weatherServiceStub.getWeatherObject();
        //then
        assertNotNull(weatherArrayWithTemperatureInfoFromFiveDays);
        assertThat(weatherArrayWithTemperatureInfoFromFiveDays, is(notNullValue()));
        //System.out.println(weatherArrayWithTemperatureInfoFromFiveDays);
    }

    @Test
    void weatherServiceDataShouldBeNullWhenEnteredCityIsNotProper() throws JSONException {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub();
        //when
        JSONArray weatherArrayWithTemperatureInfoFromFiveDays = weatherServiceStub.getWeatherObject();
        //then
        assertNull(weatherArrayWithTemperatureInfoFromFiveDays);
        assertThat(weatherArrayWithTemperatureInfoFromFiveDays, is(nullValue()));
    }

    @Test
    void referencesToTheSameObjectShouldBeEqual() {
        //given
        WeatherServiceStub weatherServiceStub1 = new WeatherServiceStub("Warsaw");
        WeatherServiceStub weatherServiceStub2 = weatherServiceStub1;
        //then
        assertSame(weatherServiceStub1, weatherServiceStub2);
        assertThat(weatherServiceStub1, sameInstance(weatherServiceStub2));
    }

    @Test
    void newlyCreatedWeatherServiceShouldNotHaveDefaultCityNameSet() {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub();
        //when
        String cityName = weatherServiceStub.getCityName();
        //then
        assertNull(cityName);
        assertThat(cityName, is(nullValue()));
    }

    @Test
    void cityNameShouldNotBeNullAfterBeingSet() {
        //given
        WeatherServiceStub weatherServiceStub = new WeatherServiceStub();
        weatherServiceStub.setCityName("Warsaw");
        //when
        String cityName = weatherServiceStub.getCityName();
        //then
        assertNotNull(cityName);
        assertThat(cityName, is(notNullValue()));
    }

}