package com.peter.weatherapp.WeatherApp.view;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LogoAppTest {

    public static final String LOGO_APP_RESOURCE = "/weather_icon.png";

    @Test
    void logoAppShouldHasProperRecourseLocation() {
        //given
        LogoApp logoApp = new LogoApp();
        //when
        //then
        assertThat(logoApp.getLogoAppLocation(), sameInstance(LOGO_APP_RESOURCE));
    }
}