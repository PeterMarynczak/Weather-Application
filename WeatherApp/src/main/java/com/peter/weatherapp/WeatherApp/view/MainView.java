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
import java.time.LocalDate;
import java.util.ArrayList;


@SpringUI
public class MainView extends UI {

    @Autowired
    private WeatherService weatherService;
    private VerticalLayout mainLayout;
    private NativeSelect<String> unitSelect;
    private TextField cityTextField1;
    private TextField cityTextField2;
    private Button showWeatherButton;

    private Label currentLocationTitle1;
    private Label currentLocationTitle2;
    private Label currentLocationTitle3;
    private Label currentLocationTitle4;
    private Label currentLocationTitle5;
    private Label currentLocationTitle6;
    private Label currentLocationTitle7;
    private Label currentLocationTitle8;
    private Label currentLocationTitle9;
    private Label currentLocationTitle10;

    private Label currentTemp1;
    private Label currentTemp2;
    private Label currentTemp3;
    private Label currentTemp4;
    private Label currentTemp5;
    private Label currentTemp6;
    private Label currentTemp7;
    private Label currentTemp8;
    private Label currentTemp9;
    private Label currentTemp10;

    private Image iconImage1;
    private Image iconImage2;
    private Image iconImage3;
    private Image iconImage4;
    private Image iconImage5;
    private Image iconImage6;
    private Image iconImage7;
    private Image iconImage8;
    private Image iconImage9;
    private Image iconImage10;

    private HorizontalLayout dashBoardMainFirstDay;
    private HorizontalLayout dashBoardMainSecondDay;
    private HorizontalLayout dashBoardMainThirdDay;
    private HorizontalLayout dashBoardMainFourthDay;
    private HorizontalLayout dashBoardMainFifthDay;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setUpLayout();

        HorizontalLayout headerApp = new HeaderApp().buildHeader();
        mainLayout.addComponent(headerApp);
        HorizontalLayout logoApp = new LogoApp().buildLogo();
        mainLayout.addComponent(logoApp);

        setUpForm();
        dashBoardTitle();

        showWeatherButton.addClickListener(clickEvent -> {
            if (((!cityTextField1.getValue().equals("") && (!cityTextField2.getValue().equals(""))))){
                try {
                    updateUI();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Notification.show("Entered City name is invalid or doesn't exist");
                }
            } else Notification.show("Please enter a city");
        });
    }

    private void setUpLayout() {

        iconImage1 = new Image();
        iconImage2 = new Image();
        iconImage3 = new Image();
        iconImage4 = new Image();
        iconImage5 = new Image();
        iconImage6 = new Image();
        iconImage7 = new Image();
        iconImage8 = new Image();
        iconImage9 = new Image();
        iconImage10 = new Image();

        mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setMargin(true);
        mainLayout.setSpacing(true);

        mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        setContent(mainLayout);

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

        //Adding TextField for 1st Location
        cityTextField1 = new TextField();
        cityTextField1.setWidth("300px");
        cityTextField1.setPlaceholder("Enter city you are starting from");
        formLayout.addComponents(cityTextField1);

        //Adding TextField for 2nd Location
        cityTextField2 = new TextField();
        cityTextField2.setWidth("300px");
        cityTextField2.setPlaceholder("Enter destination city");
        formLayout.addComponents(cityTextField2);

        showWeatherButton = new Button();
        showWeatherButton.setIcon(VaadinIcons.SEARCH);
        formLayout.addComponents(showWeatherButton);

        mainLayout.addComponents(formLayout);
    }

    private void dashBoardTitle() {

        dashBoardMainFirstDay = new HorizontalLayout();
        dashBoardMainFirstDay.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        dashBoardMainFirstDay.setMargin(false);

        dashBoardMainSecondDay = new HorizontalLayout();
        dashBoardMainSecondDay.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        dashBoardMainSecondDay.setMargin(false);

        dashBoardMainThirdDay = new HorizontalLayout();
        dashBoardMainThirdDay.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        dashBoardMainThirdDay.setMargin(false);

        dashBoardMainFourthDay = new HorizontalLayout();
        dashBoardMainFourthDay.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        dashBoardMainFourthDay.setMargin(false);

        dashBoardMainFifthDay = new HorizontalLayout();
        dashBoardMainFifthDay.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        dashBoardMainFifthDay.setMargin(false);

        currentLocationTitle1 = new Label();
        currentLocationTitle1.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle1.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle2 = new Label();
        currentLocationTitle2.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle2.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle3 = new Label();;
        currentLocationTitle3.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle3.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle4 = new Label();
        currentLocationTitle4.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle4.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle5 = new Label();
        currentLocationTitle5.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle5.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle6 = new Label();
        currentLocationTitle6.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle6.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle7 = new Label();
        currentLocationTitle7.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle7.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle8 = new Label();
        currentLocationTitle8.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle8.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle9 = new Label();
        currentLocationTitle9.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle9.addStyleName(ValoTheme.LABEL_LIGHT);

        currentLocationTitle10 = new Label();
        currentLocationTitle10.addStyleName(ValoTheme.LABEL_H3);
        currentLocationTitle10.addStyleName(ValoTheme.LABEL_LIGHT);


        //Current Temperature Label
        currentTemp1 = new Label();
        currentTemp1.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp1.addStyleName(ValoTheme.LABEL_H2);
        currentTemp1.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp2 = new Label();
        currentTemp2.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp2.addStyleName(ValoTheme.LABEL_H2);
        currentTemp2.addStyleName(ValoTheme.LABEL_LIGHT);

        //Current Temperature Label
        currentTemp3 = new Label();
        currentTemp3.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp3.addStyleName(ValoTheme.LABEL_H2);
        currentTemp3.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp4 = new Label();
        currentTemp4.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp4.addStyleName(ValoTheme.LABEL_H2);
        currentTemp4.addStyleName(ValoTheme.LABEL_LIGHT);

        //Current Temperature Label
        currentTemp5 = new Label();
        currentTemp5.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp5.addStyleName(ValoTheme.LABEL_H2);
        currentTemp5.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp6 = new Label();
        currentTemp6.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp6.addStyleName(ValoTheme.LABEL_H2);
        currentTemp6.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp7 = new Label();
        currentTemp7.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp7.addStyleName(ValoTheme.LABEL_H2);
        currentTemp7.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp8 = new Label();
        currentTemp8.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp8.addStyleName(ValoTheme.LABEL_H2);
        currentTemp8.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp9 = new Label();
        currentTemp9.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp9.addStyleName(ValoTheme.LABEL_H2);
        currentTemp9.addStyleName(ValoTheme.LABEL_LIGHT);

        currentTemp10 = new Label();
        currentTemp10.addStyleName(ValoTheme.LABEL_BOLD);
        currentTemp10.addStyleName(ValoTheme.LABEL_H2);
        currentTemp10.addStyleName(ValoTheme.LABEL_LIGHT);


    }

    public void updateUI() throws JSONException {

        String firstLocation = cityTextField1.getValue();
        String secondLocation = cityTextField2.getValue();

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

        //setting main City as 1st Location entered by User
        weatherService.setCityName(firstLocation);
        //setting default temperature unit chose by User
        weatherService.setUnit(defaultUnit);

        currentLocationTitle1.setValue("Today in " + firstLocation);
        currentLocationTitle2.setValue("Today in " + secondLocation);

        currentLocationTitle3.setValue("Tomorrow in " + firstLocation);
        currentLocationTitle4.setValue("Tomorrow in " + secondLocation);

        //Getting current day and setting 3rd, 4th and 5th day
        LocalDate thirdDay = LocalDate.now().plusDays(2);
        LocalDate fourthDay = LocalDate.now().plusDays(3);
        LocalDate fifthDay = LocalDate.now().plusDays(4);

        currentLocationTitle5.setValue("On " + thirdDay.toString() + " in " + firstLocation);
        currentLocationTitle6.setValue("On " + thirdDay.toString() + " in " + secondLocation);

        currentLocationTitle7.setValue("On " + fourthDay.toString() + " in " + firstLocation);
        currentLocationTitle8.setValue("On " + fourthDay.toString() + " in " + secondLocation);

        currentLocationTitle9.setValue("On " + fifthDay.toString() + " in " + firstLocation);
        currentLocationTitle10.setValue("On " + fifthDay.toString() + " in " + secondLocation);

        //getting  JSON Array for objects from 1st Location
        JSONArray arrayFromFirstLocation = weatherService.getWeatherObject(firstLocation, defaultUnit);

        String[] iconCodesFromFirstLocation = new String[5];
        String[] iconCodesFromSecondLocation = new String[5];

        Double[] tempValuesFromFirstLocation = new Double[5];
        Double[] tempValuesFromSecondLocation = new Double[5];

        int iconCodesIterator = 0;

            for (int i = 0; i < 40; i += 8) {

                JSONObject myObject = (JSONObject) arrayFromFirstLocation.getJSONObject(i).get("main");
                double temp = myObject.getDouble("temp");

                //locating temp values into an array
                tempValuesFromFirstLocation[iconCodesIterator]= temp;

                //Setup icon image
                String iconCode1 = "";

                //getting weather description from Weather API
                JSONArray jsonArray = arrayFromFirstLocation.getJSONObject(i).getJSONArray("weather");

                for (int j = 0; j < jsonArray.length() ; j++) {
                    JSONObject weatherObject = jsonArray.getJSONObject(j);
                    iconCode1 = weatherObject.getString("icon");
                    //locating icon values into an array
                    iconCodesFromFirstLocation[iconCodesIterator] = iconCode1;
                    //System.out.println(iconCode1);
                }
                iconCodesIterator++;
            }
            //entering temp value for each day for 1st Location
            currentTemp1.setValue(tempValuesFromFirstLocation[0] + unit);
            currentTemp3.setValue(tempValuesFromFirstLocation[1] + unit);
            currentTemp5.setValue(tempValuesFromFirstLocation[2] + unit);
            currentTemp7.setValue(tempValuesFromFirstLocation[3] + unit);
            currentTemp9.setValue(tempValuesFromFirstLocation[4] + unit);

            //setting source for iconImage for 1st Location
            iconImage1.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromFirstLocation[0] + ".png"));
            iconImage3.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromFirstLocation[1] + ".png"));
            iconImage5.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromFirstLocation[2] + ".png"));
            iconImage7.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromFirstLocation[3] + ".png"));
            iconImage9.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromFirstLocation[4] + ".png"));

        //setting main City as 2nd Location entered by User
        weatherService.setCityName(secondLocation);
        //getting new JSON Array for objects from 2nd Location
        JSONArray arrayFromSecondLocation = weatherService.getWeatherObject(secondLocation, defaultUnit);

        iconCodesIterator = 0;

        for (int i = 0; i < 40; i += 8) {

            JSONObject myObject = (JSONObject) arrayFromSecondLocation.getJSONObject(i).get("main");
            double temp = myObject.getDouble("temp");

            //locating temp values into an array
            tempValuesFromSecondLocation[iconCodesIterator]= temp;

            //Setup icon image
            String iconCode1 = "";

            //getting weather description from Weather API
            JSONArray jsonArray = arrayFromSecondLocation.getJSONObject(i).getJSONArray("weather");

            for (int j = 0; j < jsonArray.length() ; j++) {
                JSONObject weatherObject = jsonArray.getJSONObject(j);
                iconCode1 = weatherObject.getString("icon");
                //locating icon values into an array
                iconCodesFromSecondLocation[iconCodesIterator] = iconCode1;
                //System.out.println(iconCode1);
            }
            iconCodesIterator++;
        }

        //entering temp value for each day for 2nd Location
        currentTemp2.setValue(tempValuesFromSecondLocation[0] + unit);
        currentTemp4.setValue(tempValuesFromSecondLocation[1] + unit);
        currentTemp6.setValue(tempValuesFromSecondLocation[2] + unit);
        currentTemp8.setValue(tempValuesFromSecondLocation[3] + unit);
        currentTemp10.setValue(tempValuesFromSecondLocation[4] + unit);

        //setting source for iconImage for 2nd Location
        iconImage2.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromSecondLocation[0] + ".png"));
        iconImage4.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromSecondLocation[1] + ".png"));
        iconImage6.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromSecondLocation[2] + ".png"));
        iconImage8.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromSecondLocation[3] + ".png"));
        iconImage10.setSource(new ExternalResource("http://openweathermap.org/img/w/" + iconCodesFromSecondLocation[4] + ".png"));

        int obj = 0;
        if (obj == 0) {
            System.out.println(iconCodesFromFirstLocation.length);
            System.out.println(iconCodesFromSecondLocation.length);
        }

        if((iconCodesFromFirstLocation.length != 0) && (iconCodesFromSecondLocation.length != 0)) {

            dashBoardMainFirstDay.addComponents(currentLocationTitle1, iconImage1, currentTemp1, currentLocationTitle2, iconImage2, currentTemp2);
            mainLayout.addComponents(dashBoardMainFirstDay);

            dashBoardMainSecondDay.addComponents(currentLocationTitle3, iconImage3, currentTemp3, currentLocationTitle4, iconImage4, currentTemp4);
            mainLayout.addComponents(dashBoardMainSecondDay);

            dashBoardMainThirdDay.addComponents(currentLocationTitle5, iconImage5, currentTemp5, currentLocationTitle6, iconImage6, currentTemp6);
            mainLayout.addComponents(dashBoardMainThirdDay);

            dashBoardMainFourthDay.addComponents(currentLocationTitle7, iconImage7, currentTemp7, currentLocationTitle8, iconImage8, currentTemp8);
            mainLayout.addComponents(dashBoardMainFourthDay);

            dashBoardMainFifthDay.addComponents(currentLocationTitle9, iconImage9, currentTemp9, currentLocationTitle10, iconImage10, currentTemp10);
            mainLayout.addComponents(dashBoardMainFifthDay);

            iconCodesFromFirstLocation = null;
            iconCodesFromSecondLocation = null;
            tempValuesFromFirstLocation = null;
            tempValuesFromSecondLocation = null;


        } else {
            Notification.show("Entered City is invalid, please try again");
            System.out.println("fjdfhlkjdshfjkdshflkjsdhljfkdshlkgjfhljkgbh");
            System.out.println(";fjhlkjfhldksjfhldkjshfdjksafhldjkfhldskajfhl");
            cityTextField1.setValue("");
            cityTextField2.setValue("");
        }
    }

}

