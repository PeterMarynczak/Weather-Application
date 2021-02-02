package com.peter.weatherapp.WeatherApp.view;

import com.peter.weatherapp.WeatherApp.controller.WeatherService;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import javax.xml.ws.Service;

import static javax.swing.UIManager.getString;

@SpringUI(path = "")
public class MainView extends UI {
    @Autowired
    private WeatherService weatherService;
    @Override
    protected void init(VaadinRequest vaadinRequest) {

        try {
            System.out.println("Data: " + weatherService.getWeather("przemysl").getString("coord").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
