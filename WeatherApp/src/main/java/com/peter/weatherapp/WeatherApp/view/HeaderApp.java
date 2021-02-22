package com.peter.weatherapp.WeatherApp.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.themes.ValoTheme;

import static com.peter.weatherapp.WeatherApp.view.MainView.mainLayout;

public class HeaderApp {

    public void setHeader() {
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label title = new Label("Welcome in Weather App!");
        title.addStyleName(ValoTheme.LABEL_H2);
        title.addStyleName(ValoTheme.LABEL_LIGHT);
        title.addStyleName(ValoTheme.LABEL_COLORED);

        headerLayout.addComponents(title);

        mainLayout.addComponents(headerLayout);
    }
}