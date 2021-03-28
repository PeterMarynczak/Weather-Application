package com.peter.weatherapp.WeatherApp.view;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CityTextFieldTest {

@Test
    void newlyCreatedTextFieldForCityNameShouldHaveWidthOf300px() {
    //given
    CityTextField cityTextField = new CityTextField();
    //when
    //then
    assertEquals(cityTextField.getWidth(), 300);
    }
}