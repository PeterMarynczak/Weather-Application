package com.peter.weatherapp.WeatherApp.view;

import java.util.Arrays;
import java.util.List;

public class MainViewStub {

    public List<String> prepareEnteredCityNames(String firstCityName, String secondCityName) {

        if (firstCityName != null && secondCityName != null) {
            return Arrays.asList(firstCityName, secondCityName);
        } else return null;
    }

    public List<String> prepareIconCodes() {

        String[] iconCodesFromParticularLocation = {"03d", "10d", "11d", "02d", "50n"};
        //return iconCodesFromParticularLocation;
        return Arrays.asList(iconCodesFromParticularLocation);
    }

    public List<Integer> prepareTempValues() {

        Integer[] tempValuesFromParticularLocation = {10, 12, 8, 15, 10};
        //return iconCodesFromParticularLocation;
        return Arrays.asList(tempValuesFromParticularLocation);
    }
}
