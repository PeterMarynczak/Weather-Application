package com.peter.weatherapp.WeatherApp.view;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HeaderAppTest {

    public static final String APPLICATION_TITLE = "Welcome in Weather App!";

    @Test
    void headerAppShouldHasProperTitle() {
        //given
        HeaderApp headerApp = new HeaderApp();
        //when
        //then
        assertThat(headerApp.getLabelName(), sameInstance(APPLICATION_TITLE));
    }
}