package com.peter.weatherapp.WeatherApp.view;

import com.peter.weatherapp.WeatherApp.model.WeatherService;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@SpringUI
public class MainView extends UI {

    public static final String CELSIUS = "C";
    public static final String FAHRENHEIT = "F";
    public static final String TODAY_IN = "Today in ";
    public static final String TOMORROW_IN = "Tomorrow in ";
    public static final int NUM_OF_ROWS_FROM_WEATHER_API = 40;
    public static final int EACH_DAY_ITERATOR = 8;
    public static final int NR_OF_DAYS = 5;
    @Autowired
    private WeatherService weatherService;
    private VerticalLayout mainLayout;
    private NativeSelect<String> unitSelect;
    private TextField cityTextFieldFirstLocation;
    private TextField cityTextFieldSecondLocation;
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
            if (((!cityTextFieldFirstLocation.getValue().equals("") && (!cityTextFieldSecondLocation.getValue().equals(""))))) {
                try {
                    updateUI();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Notification.show("Entered City name is invalid or doesn't exist");
                    clearMainLayoutFromPreviousData();
                }
            } else Notification.show("Please enter a city");
        });
    }

    private void clearMainLayoutFromPreviousData() {
        mainLayout.removeComponent(dashBoardMainFirstDay);
        mainLayout.removeComponent(dashBoardMainSecondDay);
        mainLayout.removeComponent(dashBoardMainThirdDay);
        mainLayout.removeComponent(dashBoardMainFourthDay);
        mainLayout.removeComponent(dashBoardMainFifthDay);
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
        List<String> items = new ArrayList<>();
        items.add(CELSIUS);
        items.add(FAHRENHEIT);

        unitSelect.setItems(items);
        unitSelect.setValue(items.get(0));
        formLayout.addComponents(unitSelect);

        //Adding TextField for 1st Location
        cityTextFieldFirstLocation = new CityTextField();
        cityTextFieldFirstLocation.setPlaceholder("Enter city you are starting from");
        formLayout.addComponents(cityTextFieldFirstLocation);

        //Adding TextField for 2nd Location
        cityTextFieldSecondLocation = new CityTextField();
        cityTextFieldSecondLocation.setPlaceholder("Enter destination city");
        formLayout.addComponents(cityTextFieldSecondLocation);

        showWeatherButton = new Button();
        showWeatherButton.setIcon(VaadinIcons.SEARCH);
        formLayout.addComponents(showWeatherButton);

        mainLayout.addComponents(formLayout);
    }

    private void dashBoardTitle() {

        dashBoardMainFirstDay = createDashboard();
        dashBoardMainSecondDay = createDashboard();
        dashBoardMainThirdDay = createDashboard();
        dashBoardMainFourthDay = createDashboard();
        dashBoardMainFifthDay = createDashboard();

        currentLocationTitle1 = createLocationTitleLabel();
        currentLocationTitle2 = createLocationTitleLabel();
        currentLocationTitle3 = createLocationTitleLabel();
        currentLocationTitle4 = createLocationTitleLabel();
        currentLocationTitle5 = createLocationTitleLabel();
        currentLocationTitle6 = createLocationTitleLabel();
        currentLocationTitle7 = createLocationTitleLabel();
        currentLocationTitle8 = createLocationTitleLabel();
        currentLocationTitle9 = createLocationTitleLabel();
        currentLocationTitle10 = createLocationTitleLabel();

        currentTemp1 = createLocationTemperatureLabel();
        currentTemp2 = createLocationTemperatureLabel();
        currentTemp3 = createLocationTemperatureLabel();
        currentTemp4 = createLocationTemperatureLabel();
        currentTemp5 = createLocationTemperatureLabel();
        currentTemp6 = createLocationTemperatureLabel();
        currentTemp7 = createLocationTemperatureLabel();
        currentTemp8 = createLocationTemperatureLabel();
        currentTemp9 = createLocationTemperatureLabel();
        currentTemp10 = createLocationTemperatureLabel();
    }

    private Label createLocationTemperatureLabel() {

        Label result = new Label();
        result.addStyleName(ValoTheme.LABEL_BOLD);
        result.addStyleName(ValoTheme.LABEL_H2);
        result.addStyleName(ValoTheme.LABEL_LIGHT);
        return result;
    }

    private Label createLocationTitleLabel() {

        Label result = new Label();
        result.addStyleName(ValoTheme.LABEL_H3);
        result.addStyleName(ValoTheme.LABEL_LIGHT);
        return result;
    }

    private HorizontalLayout createDashboard() {

        HorizontalLayout result = new HorizontalLayout();
        result.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        result.setMargin(false);
        return result;
    }

    public void updateUI() throws JSONException {

        String firstLocation = cityTextFieldFirstLocation.getValue();
        String secondLocation = cityTextFieldSecondLocation.getValue();

        String selectedUnit;
        String formattedUnit;

        if (unitSelect.getValue().equals("F")) {
            selectedUnit = "imperial";
            unitSelect.setValue("F");
            formattedUnit = "\u00b0" + "F";
        } else {
            selectedUnit = "metric";
            unitSelect.setValue("C");
            formattedUnit = "\u00b0" + "C";
        }

        currentLocationTitle1.setValue(TODAY_IN + firstLocation);
        currentLocationTitle2.setValue(TODAY_IN + secondLocation);

        currentLocationTitle3.setValue(TOMORROW_IN + firstLocation);

        currentLocationTitle4.setValue(TOMORROW_IN + secondLocation);

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
        JSONArray arrayFromFirstLocation = weatherService.getWeatherObject(firstLocation, selectedUnit);

        if (arrayFromFirstLocation != null) {

            String[] iconCodesFromFirstLocation = new String[NR_OF_DAYS];
            Double[] tempValuesFromFirstLocation = new Double[NR_OF_DAYS];

            iconCodesFromFirstLocation = getIconCodes(arrayFromFirstLocation);
            tempValuesFromFirstLocation = getTempValues(arrayFromFirstLocation);

            //entering temp value for each day for 1st Location
            currentTemp1.setValue(tempValuesFromFirstLocation[0] + formattedUnit);
            currentTemp3.setValue(tempValuesFromFirstLocation[1] + formattedUnit);
            currentTemp5.setValue(tempValuesFromFirstLocation[2] + formattedUnit);
            currentTemp7.setValue(tempValuesFromFirstLocation[3] + formattedUnit);
            currentTemp9.setValue(tempValuesFromFirstLocation[4] + formattedUnit);

            iconImage1.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            iconImage3.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            iconImage5.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            iconImage7.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            iconImage9.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            
            //getting new JSON Array for objects from 2nd Location
            JSONArray arrayFromSecondLocation = weatherService.getWeatherObject(secondLocation, selectedUnit);

            if (arrayFromSecondLocation != null) {

                String[] iconCodesFromSecondLocation;
                Double[] tempValuesFromSecondLocation;

                iconCodesFromSecondLocation = getIconCodes(arrayFromSecondLocation);
                tempValuesFromSecondLocation = getTempValues(arrayFromSecondLocation);

                //entering temp value for each day for 2nd Location
                currentTemp2.setValue(tempValuesFromSecondLocation[0] + formattedUnit);
                currentTemp4.setValue(tempValuesFromSecondLocation[1] + formattedUnit);
                currentTemp6.setValue(tempValuesFromSecondLocation[2] + formattedUnit);
                currentTemp8.setValue(tempValuesFromSecondLocation[3] + formattedUnit);
                currentTemp10.setValue(tempValuesFromSecondLocation[4] + formattedUnit);

                //setting source for iconImage for 2nd Location
                iconImage2.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
                iconImage4.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
                iconImage6.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
                iconImage8.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
                iconImage10.setSource(new ClassResource("/" + iconCodesFromFirstLocation[0] + ".png"));
            }

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

        }
    }

    private String[] getIconCodes(JSONArray arrayFromLocation) throws JSONException {

        String[] iconCodesFromFirstLocation = new String[NR_OF_DAYS];
        int iconCodesIterator = 0;

        for (int i = 0; i < NUM_OF_ROWS_FROM_WEATHER_API; i += EACH_DAY_ITERATOR) {

            //Setup icon image
            String iconCode;

            //getting weather description from Weather API
            JSONArray jsonArray = arrayFromLocation.getJSONObject(i).getJSONArray("weather");

            for (int j = 0; j < jsonArray.length(); j++) {
                JSONObject weatherObject = jsonArray.getJSONObject(j);
                iconCode = weatherObject.getString("icon");
                //locating icon values into an array
                iconCodesFromFirstLocation[iconCodesIterator] = iconCode;
            }
            iconCodesIterator++;
        }
        return iconCodesFromFirstLocation;
    }

    private Double[] getTempValues(JSONArray arrayFromLocation) throws JSONException {

        Double[] tempValuesFromFirstLocation = new Double[NR_OF_DAYS];
        int tempValuesIterator = 0;


        for (int i = 0; i < NUM_OF_ROWS_FROM_WEATHER_API; i += EACH_DAY_ITERATOR) {

            JSONObject myObject = arrayFromLocation.getJSONObject(i).getJSONObject("main");
            double temp = myObject.getDouble("temp");

            //locating temp values into an array
            tempValuesFromFirstLocation[tempValuesIterator] = temp;

            tempValuesIterator++;
        }
        return tempValuesFromFirstLocation;
    }

}

