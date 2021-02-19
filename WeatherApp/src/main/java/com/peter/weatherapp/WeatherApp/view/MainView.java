package com.peter.weatherapp.WeatherApp.view;

import com.peter.weatherapp.WeatherApp.controller.WeatherService;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@SpringUI(path = "")
public class MainView extends UI {

    @Autowired
    private WeatherService weatherService;

    //private VerticalLayout mainLayout;
    public static VerticalLayout mainLayout;

    private NativeSelect<String> unitSelect;
    private TextField cityTextField1;
    private TextField cityTextField2;
    private Button showWeatherButton;
    private Label currentLocationTitle1;
    private Label currentLocationTitle2;
    private Label currentTemp1;
    private Label currentTemp2;
    private Label weatherDescription;
    private Label weatherMin;
    private Label weatherMax;
    private Label pressureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Label sunRiseLabel;
    private Label sunSetLabel;
    private Image iconImage1;
    private Image iconImage2;
    private HorizontalLayout dashBoardMain;
    private HorizontalLayout mainDescriptionLayout;
    private VerticalLayout descriptionLayout;
    private VerticalLayout pressureLayout;
    private LogoApp logoApp;
    private HeaderApp headerApp;

    private VerticalLayout myBoardMain;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUpLayout();

        //setHeader();
        HeaderApp headerApp = new HeaderApp();
        headerApp.setHeader();

        //setLogo();
        LogoApp logoApp = new LogoApp();
        logoApp.setLogo();

        setUpForm();
        dashBoardTitle();

        dashBoardDescription();

        showWeatherButton.addClickListener(clickEvent -> {
            if (((!cityTextField1.getValue().equals("") && (!cityTextField2.getValue().equals(""))))){
                updateUI();
            } else Notification.show("Please enter a city");

        });
    }

    private void setUpLayout() {

        iconImage1 = new Image();
        iconImage2 = new Image();
        weatherDescription = new Label("");
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

//    private void setHeader() {
//        HorizontalLayout headerLayout = new HorizontalLayout();
//        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
//
//        Label title = new Label("Welcome in Weather App!");
//        title.addStyleName(ValoTheme.LABEL_H1);
//        title.addStyleName(ValoTheme.LABEL_BOLD);
//        title.addStyleName(ValoTheme.LABEL_COLORED);
//
//        headerLayout.addComponents(title);
//
//        mainLayout.addComponents(headerLayout);
//    }

//    private void setLogo() {
//        HorizontalLayout logoLayout = new HorizontalLayout();
//        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
//
//        Image icon = new Image(null, new ClassResource("/weather_icon.png"));
//        icon.setWidth("125px");
//        icon.setHeight("125px");
//
//        logoLayout.addComponents(icon);
//
//        mainLayout.addComponents(logoLayout);
//
//    }

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
        unitSelect.setValue(items.get(1));
        formLayout.addComponents(unitSelect);

        //Adding TextField for 1st Location
        cityTextField1 = new TextField();
        cityTextField1.setWidth("300px");
        cityTextField1.setCaption("Enter city you are starting from");
        formLayout.addComponents(cityTextField1);

        //Adding TextField for 2nd Location
        cityTextField2 = new TextField();
        cityTextField2.setWidth("300px");
        cityTextField2.setCaption("Enter destination city");
        formLayout.addComponents(cityTextField2);

        showWeatherButton = new Button();
        showWeatherButton.setIcon(VaadinIcons.SEARCH);
        formLayout.addComponents(showWeatherButton);

        mainLayout.addComponents(formLayout);
    }

    private void dashBoardTitle() {

        dashBoardMain = new HorizontalLayout();
        dashBoardMain.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        currentLocationTitle1 = new Label("Currently in Przemyśl");
        currentLocationTitle1.addStyleName(ValoTheme.LABEL_H2);
        currentLocationTitle1.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle2 = new Label("Currently in Orły");
        currentLocationTitle2.addStyleName(ValoTheme.LABEL_H2);
        currentLocationTitle2.addStyleName(ValoTheme.LABEL_LIGHT);

        //Current Temperature Label
        currentTemp1 = new Label("19F");
        currentTemp1.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp1.addStyleName(ValoTheme.LABEL_H1);
        currentTemp1.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp2 = new Label("10F");
        currentTemp2.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp2.addStyleName(ValoTheme.LABEL_H1);
        currentTemp2.addStyleName(ValoTheme.LABEL_LIGHT);

    }

    private void dashBoardDescription() {

        mainDescriptionLayout = new HorizontalLayout();
        mainDescriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        //Description Vertical Layout
        descriptionLayout = new VerticalLayout();
        descriptionLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        descriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        descriptionLayout.addComponents(weatherDescription);
//        descriptionLayout.addComponents(weatherMin);
//        descriptionLayout.addComponents(weatherMax);

        //Description Vertical Layout
        pressureLayout = new VerticalLayout();
        pressureLayout.addStyleName(ValoTheme.FORMLAYOUT_LIGHT);
        pressureLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

//        pressureLayout.addComponents(pressureLabel);
//        pressureLayout.addComponents(humidityLabel);
//        pressureLayout.addComponents(windSpeedLabel);
//        pressureLayout.addComponents(sunRiseLabel);
//        pressureLayout.addComponents(sunSetLabel);

    }

    private void updateUI() {

        String city1 = cityTextField1.getValue();
        String city2 = cityTextField2.getValue();

        String defaultUnit;
        String unit;

        if (unitSelect.getValue().equals("F")) {
            defaultUnit = "imperial";
            unitSelect.setValue("F");
            unit = "\u00b0" + "F";
        } else {
            defaultUnit = "metric";
            unitSelect.setValue("C");
            unit = "\u00b0" + "C";
        }

        weatherService.setCityName(city1);
        weatherService.setUnit(defaultUnit);

        currentLocationTitle1.setValue("Currently in " + city1);
        currentLocationTitle2.setValue("Currently in " + city2);

        try {
            JSONObject myObject = weatherService.returnMainObject();
            double temp = myObject.getDouble("temp");
            currentTemp1.setValue(temp + unit);

            //Get min, max, pressure, humidity
            JSONObject mainObject = weatherService.returnMainObject();
            double minTemp = mainObject.getDouble("temp_min");
            double maxTemp = mainObject.getDouble("temp_max");
            int pressure = mainObject.getInt("pressure");
            int humidity = mainObject.getInt("humidity");

            //Get Wind Speed
            JSONObject windObject = weatherService.returnWindObject();
            double wind = windObject.getDouble("speed");

            //Get sunrise and sunset
            JSONObject systemObject = weatherService.returnSunSet();
            long sunRise = systemObject.getLong("sunrise") * 1000;
            long sunSet = systemObject.getLong("sunset") * 1000;

            //Setup icon image
            String iconCode1 = "";
            String description = "";
            JSONArray jsonArray = weatherService.returnWeatherArray();

            for (int i = 0; i < jsonArray.length() ; i++) {
              JSONObject weatherObject = jsonArray.getJSONObject(i);
              description = weatherObject.getString("description");
              iconCode1 = weatherObject.getString("icon");
            }
            //System.out.println(iconCode1);
            iconImage1.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCode1 + ".png"));

            dashBoardMain.addComponents(currentLocationTitle1, iconImage1, currentTemp1);
            mainLayout.addComponents(dashBoardMain);

            //Update Description UI
//            weatherDescription.setValue("Cloudiness: " + description);
//            weatherDescription.addStyleName(ValoTheme.BUTTON_FRIENDLY);
//            weatherMin.setValue("Min: " + String.valueOf(minTemp)  + unit);
//            weatherMax.setValue("Max: " + String.valueOf(maxTemp) + unit);
//            pressureLabel.setValue("Pressure: " + String.valueOf(pressure) + "hpa");
//            humidityLabel.setValue("Humidity: " + String.valueOf(humidity) + "%");
//            windSpeedLabel.setValue("Wind: " + String.valueOf(wind) + "m/s");
//            sunRiseLabel.setValue("Sunrise: " + convertTime(sunRise));
//            sunSetLabel.setValue("Sunset: " + convertTime(sunSet));

            //mainDescriptionLayout.addComponents(descriptionLayout, pressureLayout);
            //mainLayout.addComponent(mainDescriptionLayout);

            } catch (JSONException e) {
            e.printStackTrace();
        }

        weatherService.setCityName(city2);
        try {
            JSONObject myObject = weatherService.returnMainObject();
            double temp = myObject.getDouble("temp");
            currentTemp2.setValue(temp + unit);

            //Setup icon image
            String iconCode2 = "";
            String description = "";
            JSONArray jsonArray = weatherService.returnWeatherArray();

            for (int i = 0; i < jsonArray.length() ; i++) {
                JSONObject weatherObject = jsonArray.getJSONObject(i);
                description = weatherObject.getString("description");
                iconCode2 = weatherObject.getString("icon");
            }
            iconImage2.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCode2 + ".png"));
            dashBoardMain.addComponents(currentLocationTitle2, iconImage2, currentTemp2);
            mainLayout.addComponents(dashBoardMain);
            //System.out.println(iconCode2);


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