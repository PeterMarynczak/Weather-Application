package com.peter.weatherapp.WeatherApp.view;

import com.peter.weatherapp.WeatherApp.controller.WeatherService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ClassResource;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import javax.xml.ws.Service;

import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.UIManager.getString;

@SpringUI(path = "")
public class MainView extends UI {

    @Autowired
    private WeatherService weatherService;
    private VerticalLayout mainLayout;
    private NativeSelect<String> unitSelect;
    private TextField cityTextField;
    private Button showWeatherButton;
    private Label currentLocationTitle;
    private Label currentTemp;
    private Label weatherDescription;
    private Label weatherMin;
    private Label weatherMax;
    private Label pressureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Label sunRiseLabel;
    private Label sunSetLabel;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUpLayout();
        setHeader();
        setLogo();
        setUpForm();
        dashBoardTitle();
        dashBoardDescription();
    }

    private void setUpLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        setContent(mainLayout);

    }

    private void setHeader() {
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label title = new Label("Welcome in Weather App!");
        title.addStyleName(ValoTheme.LABEL_H1);
        title.addStyleName(ValoTheme.LABEL_BOLD);
        title.addStyleName(ValoTheme.LABEL_COLORED);

        headerLayout.addComponents(title);

        mainLayout.addComponents(headerLayout);
    }

    private void setLogo() {
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Image icon = new Image(null, new ClassResource("/weather_icon.png"));
        icon.setWidth("125px");
        icon.setHeight("125px");

        logoLayout.addComponents(icon);

        mainLayout.addComponents(logoLayout);

    }

    private void setUpForm() {

        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.setSpacing(true);
        formLayout.setMargin(true);

        //Creating selection of component
        unitSelect = new NativeSelect<>();
        unitSelect.setWidth("50px");
        ArrayList<String> items = new ArrayList<>();
        items.add("C");
        items.add("F");

        unitSelect.setItems(items);
        unitSelect.setValue(items.get(0));
        formLayout.addComponents(unitSelect);

        //Adding TextField
        cityTextField = new TextField();
        cityTextField.setWidth("300px");
        formLayout.addComponents(cityTextField);

        //Add Button
        showWeatherButton = new Button();
        showWeatherButton.setIcon(VaadinIcons.SEARCH);
        formLayout.addComponents(showWeatherButton);

        mainLayout.addComponents(formLayout);
    }

    private void dashBoardTitle() {
        HorizontalLayout dashBoardMain = new HorizontalLayout();
        dashBoardMain.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        currentLocationTitle = new Label("Currently in Przemyśl");
        currentLocationTitle.addStyleName(ValoTheme.LABEL_H2);
        currentLocationTitle.addStyleName(ValoTheme.LABEL_LIGHT);

        ExternalResource img = new ExternalResource("http://openweathermap.org/img/wn/11n.png");
        Embedded image = new Embedded(null, img);

        //Current Temperature Label
        currentTemp = new Label("19F");
        currentTemp.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp.addStyleName(ValoTheme.LABEL_H1);
        currentTemp.addStyleName(ValoTheme.LABEL_LIGHT);

        dashBoardMain.addComponents(currentLocationTitle, image, currentTemp);

        mainLayout.addComponents(dashBoardMain);


    }

    private void dashBoardDescription() {

        HorizontalLayout mainDescriptionLayout = new HorizontalLayout();
        mainDescriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //Description Vertical Layout
        VerticalLayout descriptionLayout = new VerticalLayout();
        descriptionLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        descriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        weatherDescription = new Label("Description: Clear Sky");
        descriptionLayout.addComponents(weatherDescription);

        weatherMin = new Label("Min: 56F");
        descriptionLayout.addComponents(weatherMin);

        weatherMax = new Label("Max: 89F");
        descriptionLayout.addComponents(weatherMax);

        //Description Vertical Layout
        VerticalLayout pressureLayout = new VerticalLayout();
        pressureLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        pressureLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        pressureLabel = new Label("Pressure: 123pa");
        pressureLayout.addComponents(pressureLabel);

        humidityLabel = new Label("Humidity: 34");
        pressureLayout.addComponents(humidityLabel);

        windSpeedLabel = new Label("Wind Speed: 123/hr");
        pressureLayout.addComponents(windSpeedLabel);

        sunRiseLabel = new Label("Sunrise");
        pressureLayout.addComponents(sunRiseLabel);

        sunSetLabel = new Label("Sunset");
        pressureLayout.addComponents(sunSetLabel);

        mainDescriptionLayout.addComponents(descriptionLayout,pressureLayout);
        mainLayout.addComponent(mainDescriptionLayout);


    }

}














//        try {
//            //System.out.println("Data: " + weatherService.getWeather("przemysl").getString("coord").toString());
//            JSONArray jsonArray = weatherService.returnWeatherArray("Przemysl");
//            JSONObject myObject = weatherService.returnMainObject("Przemysl");
//
//            System.out.println("Id: " + myObject.getLong("pressure"));
//
//            for (int i = 0; i < jsonArray.length() ; i++) {
//                JSONObject weatherObject = jsonArray.getJSONObject(i);
//
//                System.out.println("Id: " + weatherObject.getInt("id") + ":, main: " + weatherObject.getString("main") +
//                    ", description: " + weatherObject.getString("description"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }