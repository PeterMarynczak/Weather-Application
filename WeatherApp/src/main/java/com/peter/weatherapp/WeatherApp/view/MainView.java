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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

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
    private Image iconImage;
    private HorizontalLayout dashBoardMain;
    private HorizontalLayout mainDescriptionLayout;
    private VerticalLayout descriptionLayout;
    private VerticalLayout pressureLayout;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUpLayout();
        setHeader();
        setLogo();
        setUpForm();
        dashBoardTitle();
        dashBoardDescription();

        showWeatherButton.addClickListener(clickEvent -> {
            if (!cityTextField.getValue().equals("")){
                updateUI();
            } else Notification.show("Please enter a city");

        });
    }

    private void setUpLayout() {

        iconImage = new Image();
        weatherDescription = new Label("Description: Clear Sky");
        weatherMin = new Label("Min: 56F");
        weatherMax = new Label("Max: 89F");
        pressureLabel = new Label("Pressure: 123pa");
        humidityLabel = new Label("Humidity: 34");
        windSpeedLabel = new Label("Wind Speed: 123/hr");
        sunRiseLabel = new Label("Sunrise:");
        sunSetLabel = new Label("Sunset:");
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

        dashBoardMain = new HorizontalLayout();
        dashBoardMain.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        currentLocationTitle = new Label("Currently in Przemyśl");
        currentLocationTitle.addStyleName(ValoTheme.LABEL_H2);
        currentLocationTitle.addStyleName(ValoTheme.LABEL_LIGHT);

        //Current Temperature Label
        currentTemp = new Label("19F");
        currentTemp.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp.addStyleName(ValoTheme.LABEL_H1);
        currentTemp.addStyleName(ValoTheme.LABEL_LIGHT);

    }

    private void dashBoardDescription() {

        mainDescriptionLayout = new HorizontalLayout();
        mainDescriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //Description Vertical Layout
        descriptionLayout = new VerticalLayout();
        descriptionLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        descriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        descriptionLayout.addComponents(weatherDescription);
        descriptionLayout.addComponents(weatherMin);
        descriptionLayout.addComponents(weatherMax);

        //Description Vertical Layout
        pressureLayout = new VerticalLayout();
        pressureLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        pressureLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        pressureLayout.addComponents(pressureLabel);
        pressureLayout.addComponents(humidityLabel);
        pressureLayout.addComponents(windSpeedLabel);
        pressureLayout.addComponents(sunRiseLabel);
        pressureLayout.addComponents(sunSetLabel);

        //mainDescriptionLayout.addComponents(descriptionLayout, pressureLayout);
        //mainLayout.addComponent(mainDescriptionLayout);
    }

    private void updateUI() {

        String city = cityTextField.getValue();
        currentLocationTitle.setValue("Currently in " + city);
        try {
            JSONObject myObject = weatherService.returnMainObject(city);
            double temp = myObject.getDouble("temp");
            currentTemp.setValue(temp + "F");

            //Get min, max, pressure, humidity
            JSONObject mainObject = weatherService.returnMainObject(city);
            double minTemp = mainObject.getDouble("temp_min");
            double maxTemp = mainObject.getDouble("temp_max");
            int pressure = mainObject.getInt("pressure");
            int humidity = mainObject.getInt("humidity");

            //Get Wind Speed
            JSONObject windObject = weatherService.returnWindObject(city);
            double wind = windObject.getDouble("speed");

            //Get sunrise and sunset
            JSONObject systemObject = weatherService.returnSunSet(city);
            long sunRise = systemObject.getLong("sunrise") * 1000;
            long sunSet = systemObject.getLong("sunset") * 1000;


            //Setup icon image
            String iconCode = "";
            String description = "";
            JSONArray jsonArray = weatherService.returnWeatherArray(city);

            for (int i = 0; i < jsonArray.length() ; i++) {
              JSONObject weatherObject = jsonArray.getJSONObject(i);
              description = weatherObject.getString("description");
              iconCode = weatherObject.getString("icon");
              System.out.println(iconCode);
            }
            iconImage.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCode + ".png"));
            dashBoardMain.addComponents(currentLocationTitle, iconImage, currentTemp);
            mainLayout.addComponents(dashBoardMain);

            //Update Description UI
            weatherDescription.setValue("Cloudiness: " + description);
            weatherMin.setValue("Min: " + String.valueOf(minTemp));
            weatherMax.setValue("Max: " + String.valueOf(maxTemp));
            pressureLabel.setValue("Pressure: " + String.valueOf(pressure));
            humidityLabel.setValue("Humidity: " + String.valueOf(humidity));
            windSpeedLabel.setValue("Wind: " + String.valueOf(wind) + "m/s");
            sunRiseLabel.setValue("Sunrise: " + convertTime(sunRise));
            sunSetLabel.setValue("Sunset: " + convertTime(sunSet));

            mainDescriptionLayout.addComponents(descriptionLayout, pressureLayout);
            mainLayout.addComponent(mainDescriptionLayout);

            } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String convertTime(long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy hh.mm aa");

        return dateFormat.format(new Date(time));
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