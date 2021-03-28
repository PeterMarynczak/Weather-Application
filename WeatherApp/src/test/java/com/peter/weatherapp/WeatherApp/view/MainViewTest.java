package com.peter.weatherapp.WeatherApp.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;

class MainViewTest {

    private MainViewStub mainViewStub;

    @BeforeEach
    void initializeMainView() {
        mainViewStub = new MainViewStub();
    }

    @AfterEach
    void cleanUp() {
        mainViewStub = null;
    }

    @Test
    void enteredCityNamesShouldNotBeEmpty() {
        //given
        //when
        List<String> cityNamesList = mainViewStub.prepareEnteredCityNames("Krakow" , "Warsaw");
        //then
        assertThat(cityNamesList, is(notNullValue()));
    }

    @Test
    void listShouldBeEmptyWhenThereIsNoCityEntered() {
        //given
        //when
        List<String> cityNamesList = mainViewStub.prepareEnteredCityNames(null, null);
        //then
        assertThat(cityNamesList, is(nullValue()));
    }

    @Test
    void tableOfIconCodesShouldHasProperSize() {
        //given
        //when
        List<String> iconCodesFromEachCity = mainViewStub.prepareIconCodes();
        //then
        assertThat(iconCodesFromEachCity, allOf(
                notNullValue(),
                hasSize(5),
                is(not(empty()))
        ));
    }

    @Test
    void tableOfTempValuesShouldHasProperSize() {
        //given
        //when
        List<Integer> tempValuesFromEachCity = mainViewStub.prepareTempValues();
        //then
        assertAll("this is a group of assertions for temperature values",
                () -> assertThat(tempValuesFromEachCity, notNullValue()),
                () -> assertThat(tempValuesFromEachCity, hasSize(5)),
                () -> assertThat(tempValuesFromEachCity, is(not(empty())))
        );

    }

}