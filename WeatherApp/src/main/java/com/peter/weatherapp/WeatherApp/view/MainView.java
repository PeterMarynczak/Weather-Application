package com.peter.weatherapp.WeatherApp.view;

import com.peter.weatherapp.WeatherApp.controller.WeatherService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import javax.xml.ws.Service;

import java.util.Collections;

import static javax.swing.UIManager.getString;

@SpringUI(path = "")
public class MainView extends UI {
    @Autowired
    private WeatherService weatherService;
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        try {
            //System.out.println("Data: " + weatherService.getWeather("przemysl").getString("coord").toString());
            JSONArray jsonArray = weatherService.returnWeatherArray("Przemysl");
            JSONObject myObject = weatherService.returnMainObject("Przemysl");

            System.out.println("Id: " + myObject.getLong("pressure"));

            for (int i = 0; i < jsonArray.length() ; i++) {
                JSONObject weatherObject = jsonArray.getJSONObject(i);

                System.out.println("Id: " + weatherObject.getInt("id") + ":, main: " + weatherObject.getString("main") +
                    ", description: " + weatherObject.getString("description"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
